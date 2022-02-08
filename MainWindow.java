//mongodb+srv://Romulan:rockfall@cluster0.bmwrz.mongodb.net/JourneyServer?retryWrites=true&w=majority

import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class MainWindow extends JFrame implements ActionListener
{
    private JButton newEntry;
    private JButton saveEntry;
    private JButton scrollDown;
    private JButton scrollUp;
    private JButton editButton1, editButton2, editButton3;
    private JButton deleteButton1, deleteButton2, deleteButton3;
    private JPanel blueBanner;
    private JLabel yourEntries;
    private ImageIcon logoPicture;
    private ImageIcon editPicture;
    private ImageIcon deletePicture;
    private JLabel logo;
    private JLabel newEntryText;
    private JLabel entryDisp1, entryDisp2, entryDisp3;
    private JLabel entryDispTitle1, entryDispTitle2, entryDispTitle3;
    private String currentDirectory;
    private JTextArea entryWindow;
    private List<String> entryList;
    private List<String> entryListNames;
    private List<String> entryListDisplay;
    private List<String> entryListEditor;
    private int entryCount = 0;
    private int topDisplay = 0;
    private int openInEditor = 0;
    private boolean editMode;

    MainWindow()
    {
        pathFinder();
        loadEntries();
        getContentPane().setBackground(new Color(18,18,18));

        startScreenInitialiser();
        startScreenSetter();

        newJournalEntryInitialiser();
        
        setSize(1200,700);
        setLayout(null);
        setTitle("Journey");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    //methods that run on startup
    void pathFinder()
    {
        currentDirectory = System.getProperty("user.dir");
    }

    void loadEntries()
    {
        String temp, temp2 = "<html>", temp3="", temp4;
        int newlinecount = 0, looper = 0;
        File logs = new File(currentDirectory + "/logs.txt");
        entryList = new ArrayList<String>();
        entryListNames = new ArrayList<String>();
        entryListDisplay = new ArrayList<String>();
        entryListEditor = new ArrayList<String>();
        try{
            Scanner sc = new Scanner(logs);
            while(sc.hasNextLine()){
                temp = sc.nextLine();
                if(temp != "")
                    entryCount++;
                entryListNames.add(temp);
                //System.out.println(temp);
                File entryReader = new File(currentDirectory + "/" + temp);
                Scanner nsc = new Scanner(entryReader);
                while(nsc.hasNextLine()){
                    temp4 = nsc.nextLine();
                    temp2 = temp2 + temp4 + "<br>";
                    temp3 = temp3 + temp4;
                    //System.out.println(temp2);
                }
                entryList.add(temp2);
                entryListEditor.add(temp3);
                temp2="<html>";
                temp3="";
                nsc.close();
            }
            sc.close();
        }catch(FileNotFoundException e){
            System.out.println(e);
        }
        for(int i=0; i<entryCount; i++)
        {
            newlinecount = 0;
            temp=entryList.get(i);
            if(temp.length() < 100)
                looper = temp.length();
            else
                looper = 100;
            for(int j=0; j < looper-5; j++)
            {
                if((temp.substring(j,j+4)).equals("<br>"))
                    newlinecount++;
            }
            if(temp.length() > 100 && newlinecount < 4)
                temp = temp.substring(0,100) + "...";
            else if(newlinecount > 4)
                temp = temp.substring(0,20) + "...";
            entryListDisplay.add(temp);
        }
    }

    void entrySetter()
    {
        topDisplay = 0;

        entryDisp1.setVisible(false);
        entryDisp2.setVisible(false);
        entryDisp3.setVisible(false);

        entryDispTitle1.setVisible(false);
        entryDispTitle2.setVisible(false);
        entryDispTitle3.setVisible(false);

        editButton1.setVisible(false);
        editButton2.setVisible(false);
        editButton3.setVisible(false);

        deleteButton1.setVisible(false);
        deleteButton2.setVisible(false);
        deleteButton3.setVisible(false);

        scrollUp.setVisible(false);
        scrollDown.setVisible(false);

        if(entryCount >= 1)
        {
            entryDispTitle1.setVisible(true);
            entryDisp1.setVisible(true);
            editButton1.setVisible(true);
            deleteButton1.setVisible(true);

            entryDispTitle1.setText(entryListNames.get(0));
            entryDisp1.setText(entryListDisplay.get(0));
            if( entryCount >= 2)
            {
                entryDispTitle2.setVisible(true);
                entryDisp2.setVisible(true);
                editButton2.setVisible(true);
                deleteButton2.setVisible(true);

                entryDispTitle2.setText(entryListNames.get(1));
                entryDisp2.setText(entryListDisplay.get(1));
                if(entryCount >= 3)
                {
                    entryDispTitle3.setVisible(true);
                    entryDisp3.setVisible(true);
                    editButton3.setVisible(true);
                    deleteButton3.setVisible(true);
                    entryDispTitle3.setText(entryListNames.get(2));
                    entryDisp3.setText(entryListDisplay.get(2));
                }
            }
        }
        if(entryCount > 3)
            scrollDown.setVisible(true);
    }

    void startScreenInitialiser()
    {
        blueBanner = new JPanel();
        blueBanner.setBounds(0,0,1200,80);
        blueBanner.setBackground(new Color(0,191,230));

        logoPicture = new ImageIcon(currentDirectory + "/logo.png");
        logo = new JLabel(logoPicture);
        logo.setBounds(475,10,250,67);
        blueBanner.add(logo);

        newEntry = new JButton("New Entry");
        newEntry.setFont(new Font("sans serif",Font.BOLD,18));
        newEntry.setBounds(930,580,150,40);
        newEntry.setForeground(Color.WHITE);
        newEntry.setBackground(new Color(124,179,66));
        newEntry.setBorderPainted(false);
        newEntry.addActionListener(this);

        scrollUp = new JButton(new ImageIcon(currentDirectory + "/up.png"));
        scrollDown = new JButton(new ImageIcon(currentDirectory + "/down.png"));
        scrollUp.setBorderPainted(false);
        scrollDown.setBorderPainted(false);
        scrollUp.addActionListener(this);
        scrollDown.addActionListener(this);
        scrollUp.setBounds(575,180,50,21);
        scrollDown.setBounds(575,565,50,21);
        scrollUp.setVisible(false);
        if(entryCount <= 3)
        {
            scrollDown.setVisible(false);
            System.out.println("SetVisible 1");
        }

        yourEntries = new JLabel("Your Entries", JLabel.CENTER);
        yourEntries.setFont(new Font("sans serif", Font.BOLD,26));
        yourEntries.setForeground(Color.WHITE);
        yourEntries.setBounds(475,120,250,40);

        entryDispTitle1 = new JLabel();
        entryDispTitle2 = new JLabel();
        entryDispTitle3 = new JLabel();

        entryDisp1 = new JLabel("", JLabel.CENTER);
        entryDisp2 = new JLabel("", JLabel.CENTER);
        entryDisp3 = new JLabel("", JLabel.CENTER);

        //entrySetter();

        entryDispTitle1.setBounds(100,200,200,20);
        entryDispTitle2.setBounds(100,320,200,20);
        entryDispTitle3.setBounds(100,440,200,20);

        entryDisp1.setBounds(100,225,800,80);
        entryDisp2.setBounds(100,345,800,80);
        entryDisp3.setBounds(100,465,800,80);

        Font f = new Font("sans serif", Font.PLAIN, 14);
        entryDisp1.setFont(f);
        entryDisp2.setFont(f);
        entryDisp3.setFont(f);

        Font f2 = new Font("sans serif", Font.PLAIN, 18);
        entryDispTitle1.setFont(f2);
        entryDispTitle2.setFont(f2);
        entryDispTitle3.setFont(f2);

        entryDisp1.setOpaque(true);
        entryDisp2.setOpaque(true);
        entryDisp3.setOpaque(true);

        //entryDisp1.setLayout(new Layout(BorderLayout));

        entryDisp1.setBackground(new Color(35,35,35));
        entryDisp1.setForeground(Color.WHITE);
        entryDisp2.setBackground(new Color(35,35,35));
        entryDisp2.setForeground(Color.WHITE);
        entryDisp3.setBackground(new Color(35,35,35));
        entryDisp3.setForeground(Color.WHITE);

        entryDispTitle1.setForeground(Color.WHITE);
        entryDispTitle2.setForeground(Color.WHITE);
        entryDispTitle3.setForeground(Color.WHITE);

        editPicture = new ImageIcon(currentDirectory + "/edit.png");
        editButton1 = new JButton(editPicture);
        editButton2 = new JButton(editPicture);
        editButton3 = new JButton(editPicture);

        deletePicture = new ImageIcon(currentDirectory + "/delete.png");
        deleteButton1 = new JButton(deletePicture);
        deleteButton2 = new JButton(deletePicture);
        deleteButton3 = new JButton(deletePicture);

        editButton1.setBounds(920,235,60,60);
        editButton2.setBounds(920,355,60,60);
        editButton3.setBounds(920,475,60,60);

        deleteButton1.setBounds(1000,235,60,60);
        deleteButton2.setBounds(1000,355,60,60);
        deleteButton3.setBounds(1000,475,60,60);

        editButton1.addActionListener(this);
        editButton2.addActionListener(this);
        editButton3.addActionListener(this);

        deleteButton1.addActionListener(this);
        deleteButton2.addActionListener(this);
        deleteButton3.addActionListener(this);
    }

    void startScreenSetter()
    {
        entrySetter();
        add(editButton1);
        add(editButton2);
        add(editButton3);
        add(deleteButton1);
        add(deleteButton2);
        add(deleteButton3);
        add(scrollUp);
        add(scrollDown);
        add(yourEntries);
        add(entryDispTitle1);
        add(entryDispTitle2);
        add(entryDispTitle3);
        add(entryDisp1);
        add(entryDisp2);
        add(entryDisp3);
        add(newEntry);
        add(blueBanner);
    }

    void ClearStartScreen()
    {
        getContentPane().remove(yourEntries);
        getContentPane().remove(entryDisp1);
        getContentPane().remove(entryDisp2);
        getContentPane().remove(entryDisp3);
        getContentPane().remove(entryDispTitle1);
        getContentPane().remove(entryDispTitle2);
        getContentPane().remove(entryDispTitle3);
        getContentPane().remove(newEntry);
        getContentPane().remove(scrollUp);
        getContentPane().remove(scrollDown);
        getContentPane().remove(editButton1);
        getContentPane().remove(editButton2);
        getContentPane().remove(editButton3);
        getContentPane().remove(deleteButton1);
        getContentPane().remove(deleteButton2);
        getContentPane().remove(deleteButton3);
        getContentPane().validate();
        getContentPane().repaint();
    }

    void scrollUpFunction()
    {
        if(topDisplay <= 0)
            return;
        topDisplay--;
        if(topDisplay <= 0)
            scrollUp.setVisible(false);
        if((topDisplay + 3) < entryCount)
            scrollDown.setVisible(true);
        entryDisp1.setText(entryListDisplay.get(topDisplay));
        entryDisp2.setText(entryListDisplay.get(topDisplay + 1));
        entryDisp3.setText(entryListDisplay.get(topDisplay + 2));

        entryDispTitle1.setText((entryListNames.get(topDisplay)));
        entryDispTitle2.setText((entryListNames.get(topDisplay + 1)));
        entryDispTitle3.setText((entryListNames.get(topDisplay + 2)));
    }

    void scrollDownFunction()
    {
        if(entryCount - topDisplay <= 3)
            return;
        topDisplay++;
        if(topDisplay > 0)
            scrollUp.setVisible(true);
        if((topDisplay+3) == entryCount)
        {
            scrollDown.setVisible(false);
            System.out.println("SetVisible 2");
        }
        entryDisp1.setText(entryListDisplay.get(topDisplay));
        entryDisp2.setText(entryListDisplay.get(topDisplay + 1));
        entryDisp3.setText(entryListDisplay.get(topDisplay + 2));

        entryDispTitle1.setText((entryListNames.get(topDisplay)));
        entryDispTitle2.setText((entryListNames.get(topDisplay + 1)));
        entryDispTitle3.setText((entryListNames.get(topDisplay + 2)));
    }

    void logsUpdater()
    {
        String temp;
        FileWriter logger;
        try{
            logger = new FileWriter(currentDirectory + "/logs.txt");
            for(int i=0; i<entryCount; i++)
            {
                temp = entryListNames.get(i) + "\n";
                //System.out.println("Writing "+entryListNames.get(i));
                logger.write(temp);
            }
            logger.close();
        }catch(IOException e){
            System.out.println(e);
        }
    }

    void deleteButtonFunction(int but)
    {
        String temp;
        File deleter;
        if(but==1){
            temp=entryListNames.get(topDisplay);
            deleter = new File(currentDirectory + "/" + temp);
            deleter.delete();
            entryList.remove(topDisplay);
            entryListDisplay.remove(topDisplay);
            entryListNames.remove(topDisplay);
            entryCount--;
            logsUpdater();
        }
        else if(but==2){
            temp=entryListNames.get(topDisplay+1);
            deleter = new File(currentDirectory + "/" + temp);
            deleter.delete();
            entryList.remove(topDisplay+1);
            entryListDisplay.remove(topDisplay+1);
            entryListNames.remove(topDisplay+1);
            entryCount--;
            logsUpdater();
        }
        else if(but==3){
            temp=entryListNames.get(topDisplay+2);
            deleter = new File(currentDirectory + "/" + temp);
            deleter.delete();
            entryList.remove(topDisplay+2);
            entryListDisplay.remove(topDisplay+2);
            entryListNames.remove(topDisplay+2);
            entryCount--;
            logsUpdater();
        }
        System.out.println(entryCount);
    }

    void editFunction(int num)
    {
        ClearStartScreen();
        newJournalEntrySetter();
        editMode = true;
        if(num == 1)
        {
            entryWindow.setText(entryListEditor.get(topDisplay));
            openInEditor = topDisplay;
        }
        else if(num == 2)
        {
            entryWindow.setText(entryListEditor.get(topDisplay+1));
            openInEditor = topDisplay+1;
        }
        else if(num == 3)
        {
            entryWindow.setText(entryListEditor.get(topDisplay+2));
            openInEditor = topDisplay+2;
        }
    }

    void newJournalEntryInitialiser()
    {
        entryWindow = new JTextArea();
        entryWindow.setBounds(100, 140, 980, 450);
        entryWindow.setBackground(new Color(35,35,35));
        entryWindow.setForeground(Color.WHITE);
        entryWindow.setFont(new Font("sans serif", Font.PLAIN, 14));
        entryWindow.setMargin(new Insets(20,50,20,50));
        entryWindow.setCaretColor(Color.WHITE);
        entryWindow.setAutoscrolls(true);

        newEntryText = new JLabel("New Entry:");
        newEntryText.setBounds(100,100,120,30);
        newEntryText.setFont(new Font("sans serif", Font.BOLD,20));
        newEntryText.setForeground(Color.WHITE);

        saveEntry = new JButton("Save");
        saveEntry.setFont(new Font("sans serif", Font.BOLD,18));
        saveEntry.setBounds(1000,600,80, 40);
        saveEntry.setForeground(Color.WHITE);
        saveEntry.setBackground(new Color(124,179,66));
        saveEntry.addActionListener(this);
    }

    void newJournalEntrySetter()
    {
        add(saveEntry);
        add(newEntryText);
        add(entryWindow);
    }

    void saveNewEntry(boolean flag)
    {
        String str = entryWindow.getText();
        if(!str.isEmpty()){
            try{
                if(flag)
                {
                    FileWriter logs = new FileWriter(currentDirectory + "/logs.txt",true);
                    String date = new SimpleDateFormat("dd-MM-yyyy-HH-mm-ss").format(new Date());
                    FileWriter entry = new FileWriter(currentDirectory + "/" + date, false);
                    entry.write(str + "\n");
                    logs.write(date + "\n");
                    logs.close();
                    entry.close();
                }
                else
                {
                    FileWriter entry = new FileWriter(currentDirectory + "/" + entryListNames.get(openInEditor), false);
                    entry.write(str + "\n");
                    entry.close();
                }
                entryCount = 0;
                loadEntries();
                if(entryCount > 3)
                    scrollDown.setVisible(true);
            }catch(IOException e){
                System.out.println(e);
            }
            finally{
                editMode = false;
            }
        }
    }

    void clearNewJournalEntry()
    {
        entryWindow.setText("");
        remove(saveEntry);
        remove(newEntryText);
        remove(entryWindow);
        getContentPane().validate();
        getContentPane().repaint();
    }

    //Action listener
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == newEntry)
        {
            System.out.println("Button had been Pressed.");
            ClearStartScreen();
            newJournalEntrySetter();
        }
        else if(e.getSource() == saveEntry)
        {
            System.out.println("Save Button has been pressed.");
            if(editMode)
                saveNewEntry(false);
            else
                saveNewEntry(true);
            clearNewJournalEntry();
            startScreenSetter();
            entrySetter();
        }
        else if(e.getSource() == scrollUp)
        {
            System.out.println("up button has been pressed.");
            scrollUpFunction();
        }
        else if(e.getSource() == scrollDown)
        {
            System.out.println("down button has been pressed.");
            scrollDownFunction();
        }
        else if(e.getSource() == deleteButton1)
        {
            System.out.println("delete button has been pressed.");
            deleteButtonFunction(1);
            entrySetter();
        }
        else if(e.getSource() == deleteButton2)
        {
            System.out.println("delete button has been pressed.");
            deleteButtonFunction(2);
            entrySetter();
        }
        else if(e.getSource() == deleteButton3)
        {
            System.out.println("delete button has been pressed.");
            deleteButtonFunction(3);
            entrySetter();
        }
        else if(e.getSource() == editButton1)
        {
            System.out.println("delete button has been pressed.");
            editFunction(1);
        }
        else if(e.getSource() == editButton2)
        {
            System.out.println("delete button has been pressed.");
            editFunction(2);
        }
        else if(e.getSource() == editButton3)
        {
            System.out.println("delete button has been pressed.");
            editFunction(3);
        }
    }
    public static void main(String[] args)
    {
        MainWindow ob = new MainWindow();
    }
}
