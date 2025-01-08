package lim.백트래킹;

import java.util.*;
import java.io.*;

public class 실버2_16953_A_B {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int func(long num, long goal) {
        if (num == goal) {
            return 0;
        } else if (num > goal) {
            return Integer.MAX_VALUE;
        }

        int minCount = Integer.MAX_VALUE;

        int count = func(num * 2, goal);
        if (count != Integer.MAX_VALUE) {
            minCount = Math.min(minCount, count + 1);
        }

        count = func(num * 10 + 1, goal);
        if (count != Integer.MAX_VALUE) {
            minCount = Math.min(minCount, count + 1);
        }
        return minCount;
    }

    static void sol(int num, int goal) throws IOException {
        int count = func(num, goal);
        if (count == Integer.MAX_VALUE) {
            count = -1;
        } else {
            count++;
        }
        bw.write(count + "");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        sol(n, m);
        br.close();
        bw.flush();
        bw.close();
    }
}
