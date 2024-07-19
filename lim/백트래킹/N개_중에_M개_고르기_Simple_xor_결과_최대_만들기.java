package lim.백트래킹;

import java.io.*;
import java.util.*;

public class N개_중에_M개_고르기_Simple_xor_결과_최대_만들기 {
    static int[] nums;

    private static int func(int sIdx, int eIdx, int m, int xorNum) {
        if (m == 0) {
            return xorNum;
        }

        int maxNum = 0;
        for (int i = sIdx; i <= eIdx; i++) {
            xorNum ^= nums[i];
            maxNum = Math.max(func(i + 1, eIdx, m - 1, xorNum), maxNum);
            xorNum ^= nums[i];
        }
        return maxNum;
    }

    private static void sol(int n, int m) throws IOException {
        int maxNum = func(0, n - 1, m, 0);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(maxNum));
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        nums = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        sol(n, m);
        br.close();
    }
}
