import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainFile implements ActionListener
{
    JFrame frame;
    JLabel tl, new_entry;
    JPanel jp;
    //JTextArea tt;
    JButton jb;
    JTextArea tf;
    public MainFile()
    {
        frame = new JFrame();

        Color c = new Color(0,191,230);
        Color c2 = new Color(18,18,18);
        Color c3 = new Color(35,35,35);
        Color c4 = new Color(124,179,66);
        
        frame.getContentPane().setBackground(c2);

        jp = new JPanel();
        jp.setBounds(0, 0, 1200, 80);
        jp.setBackground(c);

        ImageIcon pic = new ImageIcon("D:/Java/GUI/logo2.png");
        tl = new JLabel(pic);
        //Font font = new Font("sans serif",Font.BOLD,24); 
        tl.setBounds(475, 10, 250, 67);
        //tl.setBackground(Color.BLACK);
        //tl.setForeground(Color.WHITE);
        //tl.setFont(font);
        //tl.setText("Journey");

        new_entry = new JLabel("New entry:");
        Font f2 = new Font("sans serif",Font.PLAIN,20);
        new_entry.setBounds(100,100,100,30);
        new_entry.setFont(f2);
        new_entry.setForeground(Color.WHITE);

        jb = new JButton("Save");
        jb.setFont(new Font("sans serif", Font.BOLD,18));
        jb.setBounds(1000,600,80, 40);
        jb.setForeground(Color.WHITE);
        jb.setBackground(c4);
        jb.addActionListener(this);

        tf = new JTextArea();
        tf.setBounds(100, 140, 980, 450);
        tf.setBackground(c3);
        Font f3 = new Font("sans serif", Font.PLAIN,14);
        tf.setFont(f3);
        tf.setForeground(Color.WHITE);
        tf.setMargin(new Insets(20,50,20,50));
        tf.setDisabledTextColor(Color.WHITE);
        
        frame.add(tl);
        frame.add(new_entry);
        frame.add(jp);
        frame.add(jb);
        frame.add(tf);
        frame.setSize(1200,700);
        
        frame.setLayout(null);
        frame.setTitle("MainFile");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == jb)
        {
            frame.getContentPane().remove(jp);
            System.out.println(tf.getText());
        }
    }
    public static void main(String[] args)
    {
        MainFile file = new MainFile();
    }
}
