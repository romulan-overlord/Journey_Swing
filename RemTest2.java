import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RemTest2 extends JFrame
{
    RemTest2()
    {
        setTitle("Removal on Button Press.");
        setSize(400,400);
        JButton button = new JButton("Clicky");
        button.setBounds(100, 100, 50, 20);
        add(button);
        button.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e){
                System.out.println("Button has been pressed.");
                remove(button);
                button.remove();
            }
        });
        setVisible(true);
        System.out.println("End of program.");
    }
    public static void main(String[] args)
    {
        RemTest2 on = new RemTest2();
    }
    
}
