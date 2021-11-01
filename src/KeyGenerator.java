import java.security.KeyPair;
import java.security.KeyPairGenerator;

public class KeyGenerator {
    public static void main(String args[]) throws Exception {

        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("DSA");
        keyPairGen.initialize(2048);
        KeyPair pair = keyPairGen.generateKeyPair();
        System.out.println("Keys generated");
        System.out.println("Private Key generated:\n" + pair.getPrivate());
        System.out.println("Public Keys generated:\n" + pair.getPublic());
    }
}
