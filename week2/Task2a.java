package week2;

import java.io.BufferedReader;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.zip.Adler32;

/*
 * s3646416 Inci Keleher
 * This is my implementation of task 2 from the week 2 lab:
 * 
 * Write a Java program that takes lines of characters from the
 * console and write them into a file. The input should stop 
 * when the read line contains a single ‘x’ character only. The 
 * program should also calculate the checksum of the whole input, 
 * and write it into a different file.
 */
public class Task2a {

    /***
     * 
     * @param String
     *            input
     * 
     *            calculate the checksum
     */

    public static String calcCheckSum(String input) {

        // init bytes array for checksum generation
        byte bytes[] = input.getBytes();
        // init checksum
        Adler32 checksum = new Adler32();
        // generatechecksum
        checksum.update(bytes, 0, bytes.length);
        // convert to string from long
        long checkValue = checksum.getValue();
        String checkString = Long.toString(checkValue);

        return checkString;

    }

    /***
     * 
     * reads and returns user input
     * 
     */

    public static String readInput() {

        // buffer for holding stirng
        StringBuffer buffer = new StringBuffer();
        // arraylist for checking for newlines
        ArrayList<Integer> chArrList = new ArrayList<Integer>();

        try {
            // read characters in one by one
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            int ch;

            while ((ch = in.read()) > -1) {
                chArrList.add(ch);
                char c = (char) ch;
                // print for verification pruposes
//                System.out.print(ch);
                // check for an 'x' char
                if (ch == 120) {
                    // check if previous addition to list is '\n' newline
                    if (chArrList.get(chArrList.size() - 2).equals(10)) {
                        ch = in.read();
                        chArrList.add(ch);
                        in.close();
                        // check if next addition to list is '\n' newline
                        if (chArrList.get(chArrList.size() - 1).equals(10)) {
                            break;
                        }
                    }
                }
                buffer.append(c);
            }
            //close the stream and return input to main class
            in.close();
            String returnString = buffer.toString();;
            returnString.trim();
            return returnString;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /***
     * 
     * @param cString
     * @throws IOException
     * 
     *             write character stream to file
     */

    public static void writeToFile(String cString) throws IOException {
        // convert to bytes
        byte[] bytes = cString.getBytes();
        // convert to bytes
        String filepath = "/Users/inki/Documents/workspace/Network_Programming/src/Week2/input.txt";
        OutputStream output = new FileOutputStream(filepath);
        // write data and close Stream
        output.write(bytes);
        output.flush();
        output.close();
    }

    /***
     * 
     * @param checksum
     * @throws IOException
     * 
     *             write checksum to file
     */
    public static void writeSumToFile(String checksum) throws IOException {
        // convert to bytes
        byte[] bytes = checksum.getBytes();
        // set up writepath and output stream
        String fp_checksum = "/Users/inki/Documents/workspace/Network_Programming/src/Week2/checksum.txt";
        OutputStream output = new FileOutputStream(fp_checksum);
        // write data and close stream
        output.write(bytes);
        output.flush();
        output.close();
    }

    public static void main(String args[]) {

        try {
            // take user input
            String input = readInput();
            // write to input.txt file
            writeToFile(input);
            // calculate checksum of entire input and write to checksum.txt file
            writeSumToFile(calcCheckSum(input));
        } catch (IOException e) {
        }

    }
}
