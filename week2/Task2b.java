package week2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.zip.Adler32;

/***
 * Write another program that reads a character file (e.g. the file
 * generated in the previous part of this question), prints its content to
 * the screen and calculates the checksum of the file. The program should
 * also read the checksum from another file and print it out to the screen
 * (for comparison with the calculated value).
 * 
 * @throws FileNotFoundException
 */

public class Task2b {

    /***
     * read in a file and print out the contents, also get the checksum
     * @param fp (the filepath)
     * @return the calculated checksum of the file
     * @throws FileNotFoundException
     */

    public static String readFile(String fp) throws FileNotFoundException {

        // read in the file
        FileReader fr = new FileReader(fp);
        BufferedReader reader = new BufferedReader(fr);

        // print out the stream
        String sCurrentLine;
        try {
            while ((sCurrentLine = reader.readLine()) != null) {
                System.out.println(sCurrentLine);
            }

        } catch (IOException e) {
            // Auto-generated catch block
            e.printStackTrace();
        } finally {
            // close everything
            try {
                if (reader != null)
                    reader.close();
                if (fr != null)
                    fr.close();

            } catch (IOException ex) {

                ex.printStackTrace();
            }
        }

        // return the checksum
        return calcCheckSum(reader.toString());

    }

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

    public static void main(String args[]) {

        // file path to character file of previous question
        String fp_prev = "/Users/inki/Documents/workspace/Network_Programming/src/Week2/input.txt";
        // fp to checksum file for comparison
        String fp_compare = "/Users/inki/Documents/workspace/Network_Programming/src/Week2/checksum.txt";
        // read the file
        try {
            System.out.println("charstream of previous file: ");
            // print charstream of prev file
            String prev_file = readFile(fp_prev);
            System.out.println("and checksum of this when read in: ");
            // print checksum
            System.out.println(prev_file + '\n');

            System.out.println("and checksum of comparison file: ");
            String compare_file = readFile(fp_compare);
            // print checksum
            System.out.println("and checksum of that checksum: ");
            System.out.println(compare_file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
