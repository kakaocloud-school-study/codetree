import java.util.*;
import java.io.*;

public class Main {
    static long n, s;
    public static final int MAX_S = 2000000000;

    static long parameticSearch() {
        long left = 1;
        long right = MAX_S;
        long maxNum = 0;
        while (left <= right) {
            long mid = (left + right) / 2;
            if (mid * (mid + 1) / 2 <= s) {
                left = mid + 1;
                maxNum = Math.max(maxNum, mid);
            } else {
                right = mid - 1;
            }
        }
        return maxNum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = Long.parseLong(br.readLine());

        System.out.println(parameticSearch());
    }
}