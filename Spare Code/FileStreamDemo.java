//package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileStreamDemo {
    public static void main(String[] args) {

        // Code to create a new file
        /*
        File myFile = new File("cwh111file.txt");
        try {
            myFile.createNewFile();
        } catch (IOException e) {
            System.out.println("Unable to create this file");
            e.printStackTrace();
        }


        // Code to write to a file
        try {
            FileWriter fileWriter = new FileWriter("cwh111file.txt");
            fileWriter.write("This is our first file from this java course\nOkay now bye");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Reading a file
        File myFile = new File("cwh111file.txt");
        try {
            Scanner sc = new Scanner(myFile);
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                System.out.println(line);
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        */
        // Deleting a file
        File myFile = new File("cwh111file.txt");
        if(myFile.delete()){
            System.out.println("I have deleted: " + myFile.getName());
        }
        else{
            System.out.println("Some problem occurred while deleting the file");
        }

    }
}

/*
import java.text.SimpleDateFormat;  
import java.util.Date;  
public class CurrentDateTimeExample2 {  
public static void main(String[] args) {  
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
    Date date = new Date();  
    System.out.println(formatter.format(date));  
}  
}*/

/*
import java.util.*;  
public class ListExample1{  
public static void main(String args[]){  
 //Creating a List  
 List<String> list=new ArrayList<String>();  
 //Adding elements in the List  
 list.add("Mango");  
 list.add("Apple");  
 list.add("Banana");  
 list.add("Grapes");  
 //Iterating the List element using for-each loop  
 for(String fruit:list)  
  System.out.println(fruit);  
  
}  
}  */