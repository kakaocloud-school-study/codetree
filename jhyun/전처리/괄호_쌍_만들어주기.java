import java.util.*;
import java.io.*;

public class Main {
    static int MAX_N = 100000;
    static int[] R = new int[MAX_N];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String A = br.readLine();
        int n = A.length();

        R[n - 1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            if (A.charAt(i) == ')' && A.charAt(i + 1) == ')') {
                R[i] = R[i + 1] + 1;
            } else {
                R[i] = R[i + 1];
            }
        }

        long ans = 0;
        for (int i = 0; i < n - 2; i++) {
            if (A.charAt(i) == '(' && A.charAt(i + 1) == '(') {
                ans += R[i + 2];
            }
        }

        System.out.print(ans);
    }
}