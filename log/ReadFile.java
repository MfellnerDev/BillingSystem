package log;

import java.io.*;
/**
 * readFile, reads a file and returns the content in it
 *
 * @author Manuel Fellner
 * @version 2022-01-23
 */
public class ReadFile {
    public static void readFile() {

        String fileNameString = "data.txt";
        char content = ' ';

        try {
            FileInputStream inputStream = new FileInputStream(fileNameString);
            InputStreamReader reader = new InputStreamReader(inputStream, "UTF-8");
            int character;
            while ((character = reader.read()) != -1) {
                System.out.print((char) character);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
