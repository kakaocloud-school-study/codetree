import java.util.*;
import java.io.*;

public class Main {
    static String runLengthEncoding(String input) {
        String encoded = "";

        char currChar = input.charAt(0);
        int numChar = 1;
        for (int i = 1; i < (int) input.length(); i++) {
            if (input.charAt(i) == currChar) {
                numChar++;
            } else {
                encoded += currChar;
                encoded += String.valueOf(numChar);
                currChar = input.charAt(i);
                numChar = 1;
            }
        }

        encoded += currChar;
        encoded += String.valueOf(numChar);
        return encoded;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int minLength = runLengthEncoding(input).length();
        int n = input.length();
        int numShift = n - 1;

        while (numShift-- > 0) {
            input = input.substring(n - 1) + input.substring(0, n - 1);
            int length = runLengthEncoding(input).length();
            if (minLength > length) {
                minLength = length;
            }
        }

        System.out.print(minLength);
    }
}