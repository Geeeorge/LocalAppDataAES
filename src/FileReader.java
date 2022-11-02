import java.io.*;

public class FileReader {


    public static void main(String[] encryptedMessage) throws IOException {
        

        File file = new File("");
        FileWriter fw = new FileWriter(file);
        PrintWriter pw = new PrintWriter(fw);

        pw.println(encryptedMessage);    
    
        pw.close();
    }
}