import javax.swing.*;
import java.util.Scanner;

public class RemTest {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num;
        JFrame frame = new JFrame("My Frame");
        JPanel panel = new JPanel();
        JLabel label = new JLabel("This is a label.");
        
        frame.setSize(600,600);
        label.setBounds(100,100,200,40);
        panel.add(label);
        frame.add(panel);
        
        frame.setVisible(true);
        System.out.println("Enter Number: ");
        num = sc.nextInt();
        if(num==1)
        {
            System.out.println("breakpoint why?");
            //frame.remove(panel);
            panel.remove(label);
            System.out.println("Deletion attempted");
            //frame.getContentPane().removeAll();
        }
        else{
            System.out.println("Deletion Cancelled.");
        }
        sc.close();
    }
}
