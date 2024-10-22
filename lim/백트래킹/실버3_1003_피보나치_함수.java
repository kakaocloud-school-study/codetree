package lim.백트래킹;

import java.util.*;
import java.io.*;

public class 실버3_1003_피보나치_함수 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] queries;
    static int[][] mem;

    static int[] fibonacci(int n) {
        if (mem[n][0] != 0 || mem[n][1] != 0) {
            return mem[n];
        }
        if (n == 0) {
            return new int[] { 1, 0 };
        } else if (n == 1) {
            return new int[] { 0, 1 };
        } else {
            int[] result1 = fibonacci(n - 1);
            int[] result2 = fibonacci(n - 2);
            mem[n] = new int[] { result1[0] + result2[0], result1[1] + result2[1] };
            return mem[n];
        }
    }

    static void sol() throws IOException {
        for (int num : queries) {
            int[] result = fibonacci(num);
            bw.write(result[0] + " " + result[1] + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        queries = new int[n];
        mem = new int[41][2];
        for (int i = 0; i < queries.length; i++) {
            st = new StringTokenizer(br.readLine());
            queries[i] = Integer.parseInt(st.nextToken());
        }
        sol();
        br.close();
    }
}
