import java.util.*;
import java.io.*;

public class Main {
    static final int MAX_N = 1000;
    static int n;
    static String a, b;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        a = br.readLine();
        b = br.readLine();

        int ans = 0;
        boolean mismatched = false;
        for (int i = 0; i < n; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                if (!mismatched) {
                    mismatched = true;
                    ans++;
                }
            } else {
                mismatched = false;
            }
        }
        System.out.print(ans);
    }
}