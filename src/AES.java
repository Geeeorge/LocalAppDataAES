import java.io.IOException;
import java.util.Base64;
import java.io.*;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;

public class AES {
    private SecretKey key;
    private int KEY_SIZE = 128;
    private int T_LEN = 128;
    private Cipher encryptionCipher;

    public void init() throws Exception{
        KeyGenerator generator = KeyGenerator.getInstance("AES");
        generator.init(KEY_SIZE);
        key = generator.generateKey();
    }

    public String encrypt(String message) throws Exception {
        byte[] messageInBytes = message.getBytes();
        encryptionCipher = Cipher.getInstance("AES/GCM/NoPadding");
        encryptionCipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedBytes = encryptionCipher.doFinal(messageInBytes);
        return encode(encryptedBytes);
    }

    public String decrypt(String encryptedMessage) throws Exception {
        byte[] messageInBytes = decode(encryptedMessage);
        Cipher decryptionCipher = Cipher.getInstance("AES/GCM/NoPadding");
        GCMParameterSpec spec = new GCMParameterSpec(T_LEN, encryptionCipher.getIV());
        decryptionCipher.init(Cipher.DECRYPT_MODE, key, spec);
        byte[] decryptedBytes = decryptionCipher.doFinal(messageInBytes);
        return new String(decryptedBytes);
    
    }

    private String encode(byte[] data) { return Base64.getEncoder().encodeToString(data);}

    private byte[] decode(String data) { return Base64.getDecoder().decode(data); }

    public static void main(String[] args)  throws IOException {

        try {
            AES aes = new AES();
            aes.init();
            String encryptedMessage = aes.encrypt("yes");
            String decryptedMessage = aes.decrypt(encryptedMessage); 

            System.err.println(encryptedMessage);
            System.err.println(decryptedMessage); 

            File file = new File("loginCache.txt");
            FileWriter fw = new FileWriter(file);
            PrintWriter pw = new PrintWriter(fw);

            pw.println(encryptedMessage);    
    
            pw.close();

            

        } catch (Exception ignored) {

        }
    }
}
