package log;

import java.io.*;

/**
 * writeFile - generates a file with a specific content and stores it in it, txt file
 *
 * @author Manuel Fellner
 * @version 2022-01-23
 */
public class LogFile {
    /**
     * writeFile
     *
     * @param content the content that should be stored in a file
     * @return true or false
     */
    public static boolean writeFile(String content, String billingID) {
        content = LogFile.deleteWhiteSpace(content);
        try {
            if (content != "") {
                FileWriter fstream = new FileWriter(billingID + ".txt");
                BufferedWriter outP = new BufferedWriter(fstream);
                outP.write(content);
                outP.close();
            }
        } catch (Exception ex) {
            System.err.println("Error: " + ex.getMessage());
            return false;
        }
        return true;
    }

    public static String deleteWhiteSpace(String content) {
        for (int i = 0; i < content.length(); i++) {
            content = content.replace(' ', '-');
        }
        return content;
    }
}
