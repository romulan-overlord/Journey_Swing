import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RemTest2 extends JFrame
{
    RemTest2()
    {
        setTitle("Removal on Button Press.");
        setSize(400,400);
        JPanel panel = new JPanel();
        JButton button = new JButton("Clicky");
        button.setBounds(100, 100, 50, 20);
        panel.add(button);
        add(panel);
        button.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e){
                System.out.println("Button has been pressed.");
                //button.setVisible(false);
                panel.remove(button);
                getContentPane().validate();
                getContentPane().repaint();         //discord is amazing
                //remove(button);
                //button.remove();
            }
        });
        setVisible(true);
    }
    public static void main(String[] args)
    {
        RemTest2 on = new RemTest2();
    }
    
}
