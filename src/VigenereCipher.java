import java.util.Scanner;

public class VigenereCipher {

    public static void vigenereEncryptDecrypt(String text, String keyword) {

        char msg[] = text.toCharArray();
        int msgLen = msg.length;
        int i, j;

        char key[] = new char[msgLen];
        char encryptedMsg[] = new char[msgLen];
        char decryptedMsg[] = new char[msgLen];

        for (i = 0, j = 0; i < msgLen; i++, j++) {
            if (j == keyword.length()) {
                j = 0;
            }
            key[i] = keyword.charAt(j);
        }

        for (i = 0; i < msgLen; i++) {
            encryptedMsg[i] = (char) (((msg[i] + key[i]) % 26) + 'A');
        }

        for (i = 0; i < msgLen; i++) {
            decryptedMsg[i] = (char) ((((encryptedMsg[i] - key[i]) + 26) % 26) + 'A');
        }

        System.out.println("Final Keyword used to encrypt the message: " + String.valueOf(key));
        System.out.println("Encrypted Message: " + String.valueOf(encryptedMsg));
        System.out.println("Decrypted Message: " + String.valueOf(decryptedMsg));
    }

    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string to encrypt (Vigenere Cipher): ");
        String text = sc.nextLine().toUpperCase();
        System.out.println("Enter a text as a key that you desire to encrypt with: ");
        String key = sc.nextLine().toUpperCase();
        sc.close();
        vigenereEncryptDecrypt(text, key);
    }
}