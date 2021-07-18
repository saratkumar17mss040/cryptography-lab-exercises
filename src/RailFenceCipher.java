import java.util.Scanner;

public class RailFenceCipher {

    public static void print2DArray(int row, int column, char[][] a) {

        // simply printing the 2d matriX for checking
        for (int i = 0; i < row; i++) {
            for (int k = 0; k < column; k++) {
                System.out.print(a[i][k] + " ");
            }
            System.out.println();
        }
    }

    public static char[][] placeCharactersWithGivenDepth(String mapto, String text, int key) {

        boolean check = false;
        int j = 0, row = key, column = text.length();
        char[][] a = new char[row][column];

        // this loop simply helps in constructing the matrix or the 2d array based on
        // the depth given by the user

        // loop through each column
        for (int i = 0; i < column; i++) {
            // check whether we are in the 1st box or in the last box - row
            if (j == 0 || j == key - 1) {
                check = !check;
            }

            if (mapto.equals("character")) {
                a[j][i] = text.charAt(i);
            } else if (mapto.equals("hash")) {
                a[j][i] = '#';
            }

            // based on check we decide to go up or down direction
            if (check) {
                // go down
                j++;
            } else {
                // go up
                j--;
            }
        }

        return a;
    }

    public static String encryption(String text, int key) {

        String encryptedText = "";
        String mapTo = "character";
        int row = key, column = text.length();
        char[][] a;

        // 2d matrix characters mapperd to the given depth
        a = placeCharactersWithGivenDepth(mapTo, text, key);

        // loop through every row
        for (int i = 0; i < row; i++) {
            // loop through every columns element for every row
            for (int k = 0; k < column; k++) {
                // if there is some element that is not equal to 0
                if (a[i][k] != 0) {
                    // append the element
                    encryptedText += a[i][k];
                }
            }
        }

        System.out.println("Encrypted matrix:");
        print2DArray(row, column, a);

        return encryptedText;
    }

    public static String decryption(String text, int key) {

        String decryptedText = "";
        String mapTo = "hash";
        boolean check = false;
        int j = 0, row = key, column = text.length();
        char[][] a;

        a = placeCharactersWithGivenDepth(mapTo, text, key);

        System.out.println("Placeholder matrix before actual decryption:");
        print2DArray(row, column, a);

        int index = 0;

        // check if the current element contains '#'
        for (int i = 0; i < row; i++) {
            for (int k = 0; k < column; k++) {
                // if the character is '#'
                if (a[i][k] == '#') {
                    // Here we replace the '#' to correct characters
                    // assign the encrypted text each character - placing the characters
                    a[i][k] = text.charAt(index++);
                }
            }
        }

        // here we go through in the same path as depth for encryption
        // loop through each column
        for (int i = 0; i < column; i++) {
            // check whether we are in the 1st box or in the last box - row
            if (j == 0 || j == key - 1) {
                check = !check;
            }
            // and get the correct character
            decryptedText += a[j][i];

            // based on check we decide to go up or down direction
            if (check) {
                // go down
                j++;
            } else {
                // go up
                j--;
            }
        }
        return decryptedText;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a text to encrypt (Railfence Cipher):");
        String text = sc.nextLine();
        System.out.println("Enter the key (i.e) the depth that you desire to encrypt with (simply rows :) ) :");
        int key = sc.nextInt();
        sc.close();
        if (key >= text.length()) {
            System.out.println(
                    "Encrption and decryption is the same as entered text. Please enter the key (i.e) depth less than the given character length \n");
        } else {
            String encryptedText = encryption(text, key);
            System.out.println("Encrypted message:" + encryptedText + "\n");
            System.out.println("Decrypted message:" + decryption(encryptedText, key) + "\n");
        }
    }
}
