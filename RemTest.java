import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class RemTest {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num;
        JFrame frame = new JFrame("My Frame");
        JLabel label = new JLabel("This is a label.");
        JButton jb = new JButton("Button");
        
        jb.setBounds(50,50,50,20);
        
        frame.setSize(600,600);
        label.setBounds(100,100,200,40);
        frame.add(jb);
        frame.add(label);
        
        frame.setVisible(true);
        System.out.println("Enter Number: ");
        num = sc.nextInt();
        if(num==1){
            //frame.delete(label);
            frame.getContentPane().removeAll();
            System.out.println("Deletion Attempt Successful");
        }
        else{
            System.out.println("Deletion Cancelled.");
        }
        sc.close();
    }
}
