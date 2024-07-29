import java.util.*;
import java.io.*;


public class Main {
    static final int MAX_N = 10;

    static int n, k;
    static int[] coins = new int[MAX_N];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        int ans = 0;

        for (int i = n - 1; i >= 0; i--) {
            ans += k / coins[i];
            k %= coins[i];
        }

        System.out.print(ans);
    }
}