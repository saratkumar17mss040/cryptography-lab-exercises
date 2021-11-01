import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.Signature;
import java.util.Scanner;

public class DigitalSignature {
    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in);
        System.out.println("DIGITAL SIGNATURE:");
        System.out.println("Enter some text:");
        String msg = sc.nextLine();
        sc.close();
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("DSA");
        keyPairGen.initialize(2048);
        KeyPair pair = keyPairGen.generateKeyPair();
        PrivateKey privKey = pair.getPrivate();
        Signature sign = Signature.getInstance("SHA256withDSA");
        sign.initSign(privKey);
        byte[] bytes = msg.getBytes();
        sign.update(bytes);
        byte[] signature = sign.sign();
        System.out.println("\nDigital signature for given text: " + new String(signature, "UTF8"));
    }
}
