import java.util.Scanner;

public class CaesarCipher {

    public static String caeserEncryptDecrypt(String encryptOrDecrypt, String text, int shifts) {

        if (encryptOrDecrypt.equals("decrypt")) {
            // shifts = tnoal - shifts
            shifts = 26 - shifts;
        }

        String result = "";
        char ch;

        for (int i = 0; i < text.length(); i++) {
            if (Character.isUpperCase(text.charAt(i))) {
                // getting the character + noshiftd - A's ascii code % tnofa + A's ascii code
                ch = (char) (((int) text.charAt(i) + shifts - 65) % 26 + 65);
                result += ch;
            } else {
                // getting the character + noshiftd - a's ascii code % tnofa + a's ascii code
                ch = (char) (((int) text.charAt(i) + shifts - 97) % 26 + 97);
                result += ch;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string to encrypt (Ceaser Cipher): ");
        String text = sc.nextLine().replaceAll(" ", "");
        System.out.println("Enter the number of shift that you desire: ");
        int shifts = sc.nextInt();
        sc.close();
        String encryptedText = caeserEncryptDecrypt("encrypt", text, shifts).toString();
        String decryptedText = caeserEncryptDecrypt("decrypt", encryptedText, shifts).toString();
        System.out.println("Encrypted text: " + encryptedText);
        System.out.println("Decrypted text: " + decryptedText);
    }
}