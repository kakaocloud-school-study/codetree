package lim.DP;

import java.util.*;
import java.io.*;

public class subproblem을_그대로_합치면_되는_DP_갈_수_있는_곳들 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] fibNums;

    static int fib(int num) {
        if (num < 3) {
            return 1;
        }

        if (fibNums[num] != 0) {
            return fibNums[num];
        }

        fibNums[num] = fib(num - 1) + fib(num - 2);
        return fibNums[num];
    }

    static void sol(int num) throws IOException {
        int answer = fib(num);
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        fibNums = new int[n + 1];
        sol(n);
        br.close();
    }
}
