import java.util.*;
import java.io.*;

public class Main {
    static long n, k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Long.parseLong(br.readLine());
        k = Long.parseLong(br.readLine());

        long low = 1;
        long high = n * n;
        long ans = n * n;

        while (low <= high) {
            long mid = (low + high) / 2;
            long val = 0;

            for (int i = 1; i <= n; i++) {
                val += Math.min(n, mid / i);
            }

            if (val >= k) {
                high = mid - 1;
                ans = Math.min(ans, mid);
            } else {
                low = mid + 1;
            }
        }
        System.out.print(ans);
    }
}