package week2;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class StreamsDemo {

    public static void main(String[] args) {

        int i;
        char c;

        InputStream stream = null;

        try {
            // create new inpuit stream
            stream = new FileInputStream("/Users/inki/Documents/workspace/Network_Programming/src/Week2/input.txt");

            System.out.println("Total file size to read (in bytes) : " + stream.available());

            System.out.println("Characters printed:");

            // reads till the end of the stream
            while ((i = stream.read()) != -1) {

                // cpnvert int to char
                c = (char) i;

                System.out.print(i);

                System.out.println(c);

            }

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            try {
                // release any system resources associated with this stream
                if (stream != null) {
                    stream.close();
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
