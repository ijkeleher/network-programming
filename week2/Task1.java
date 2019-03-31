package week2;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/*
 * s3646416 Inci Keleher
 * This is my implementation of task 1 from the week 2 lab:
 * 
 * Using the Java class InputStream and OutputStream, write a 
 * program that takes a sequence of characters from the console
 * replaces each whitespace character with the underscore ’_’ 
 * character and outputs the changed text to the screen. 
 */


public class Task1 {

    public static void main(String[] args) throws IOException {
        
        //create the input stream and read in from console

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        
        //replace white space with underscores
        String replaced = input.replace(' ','_');
        
        //convert my updated string to bytes
        byte[] bytes = replaced.getBytes();
        
        //send the changed input all to console
        
        BufferedOutputStream output = new BufferedOutputStream(System.out);
        output.write(bytes);
        output.flush();
        output.close();


    }
}
