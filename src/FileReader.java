import java.io.*;


/* 

Testing methods on how to read the file that will be encrypted

*/
public class FileReader {


    public static void main(String[] encryptedMessage) throws IOException {
        

        File file = new File("");
        FileWriter fw = new FileWriter(file);
        PrintWriter pw = new PrintWriter(fw);

        pw.println(encryptedMessage);    
    
        pw.close();
        
    }
    /* ------------------------ */
    public String readFile(String filename)
    {
        String content = null;
        File file = new File(filename); // For example, foo.txt
        FileReader reader = null;
        try {
            reader = new FileReader(file);
            char[] chars = new char[(int) file.length()];
            reader.read(chars);
            content = new String(chars);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(reader != null){
                reader.close();
            }
        }
        return content;
}

}
