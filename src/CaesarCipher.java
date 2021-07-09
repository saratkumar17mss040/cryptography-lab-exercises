import java.util.Scanner;

/**
 * CaesarCipher
 */
public class CaesarCipher {

    public static boolean validateString(String str) {
        return ((!str.equals("")) && (str != null) && (str.matches("^[a-zA-Z]*$")));
    }

    // public static boolean validateString(String str) {
    // str = str.toLowerCase();
    // char[] charArray = str.toCharArray();
    // for (int i = 0; i < charArray.length; i++) {
    // char ch = charArray[i];
    // if (!(ch >= 'a' && ch <= 'z')) {
    // return false;
    // }
    // }
    // return true;
    // }

    public static StringBuffer encryptText(String text, int shifts) {

        StringBuffer result = new StringBuffer();

        for (int i = 0; i < text.length(); i++) {
            if (Character.isUpperCase(text.charAt(i))) {
                // getting the ascii code + noshiftd - A's ascii code % tnofa + A's ascii code
                char ch = (char) (((int) text.charAt(i) + shifts - 65) % 26 + 65);
                result.append(ch);
            } else {
                // getting the ascii code + noshiftd - a's ascii code % tnofa + a's ascii code
                char ch = (char) (((int) text.charAt(i) + shifts - 97) % 26 + 97);
                result.append(ch);
            }
        }
        return result;
    }

    public static StringBuffer caeserEncryptDecrypt(String encryptOrDecrypt, String text, int shifts) {

        if (encryptOrDecrypt.equals("decrypt")) {
            shifts = -shifts;
        }

        StringBuffer result = new StringBuffer();

        for (int i = 0; i < text.length(); i++) {
            if (Character.isUpperCase(text.charAt(i))) {
                // getting the ascii code + noshiftd - A's ascii code % tnofa + A's ascii code
                char ch = (char) (((int) text.charAt(i) + shifts - 65) % 26 + 65);
                result.append(ch);
            } else {
                // getting the ascii code + noshiftd - a's ascii code % tnofa + a's ascii code
                char ch = (char) (((int) text.charAt(i) + shifts - 97) % 26 + 97);
                result.append(ch);
            }
        }
        return result;
    }

    // public static StringBuffer decryptText(String text, int shifts) {

    // StringBuffer result = new StringBuffer();

    // for (int i = 0; i < text.length(); i++) {
    // if (Character.isUpperCase(text.charAt(i))) {
    // // getting the ascii code + noshiftd - A's ascii code % tnofa + A's ascii
    // code
    // char ch = (char) (((int) text.charAt(i) - shifts - 65) % 26 + 65);
    // result.append(ch);
    // } else {
    // // getting the ascii code + noshiftd - a's ascii code % tnofa + a's ascii
    // code
    // char ch = (char) (((int) text.charAt(i) - shifts - 97) % 26 + 97);
    // result.append(ch);
    // }
    // }
    // return result;
    // }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string to encrypt (Ceaser Cipher): ");
        String text = sc.nextLine();
        System.out.println("Enter the number of shift that you desire: ");
        int shifts = sc.nextInt();
        sc.close();
        if (validateString(text)) {
            String encryptedText = caeserEncryptDecrypt("encrypt", text, shifts).toString();
            String decryptedText = caeserEncryptDecrypt("decrypt", encryptedText, shifts).toString();
            System.out.println("Encrypted text: " + encryptedText);
            System.out.println("Decrypted text: " + decryptedText);
        } else {
            System.out.println("Please enter all the text in alphabets !");
        }
    }

}