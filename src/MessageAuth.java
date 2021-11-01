import java.security.Key;
import java.security.SecureRandom;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;

public class MessageAuth {
    public static void main(String args[]) throws Exception {
       
        KeyGenerator keyGen = KeyGenerator.getInstance("DES");
        SecureRandom secRandom = new SecureRandom();
        keyGen.init(secRandom);
        Key key = keyGen.generateKey();
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(key);
        String msg = new String("SARATHKUMAR");
        byte[] bytes = msg.getBytes();
        byte[] macResult = mac.doFinal(bytes);
        System.out.println("MESSAGE AUTHENTICATION CODE");
        System.out.println("\nTEXT : SARATHKUMAR");
        System.out.println("\nMAC RESULT:");
        System.out.println(new String(macResult));
    }
}
