package lim.백트래킹;

import java.io.*;
import java.util.*;

public class N개_중에_M개_고르기_Simple_2n개_중에_n개의_숫자를_적절하게_고르기 {
    static int[] nums;
    static int valueSum, bestHalf;

    static void renewBest(int halfSum) {
        int currDiff = Math.abs(2 * bestHalf - valueSum);
        int newDiff = Math.abs(2 * halfSum - valueSum);
        if (newDiff < currDiff) {
            bestHalf = halfSum;
        }
    }

    static void func(int sIdx, int eIdx, int m, int currSum) {
        if (m == 0) {
            renewBest(currSum);
            return;
        }

        for (int i = sIdx; i <= eIdx; i++) {
            currSum += nums[i];
            func(i + 1, eIdx, m - 1, currSum);
            currSum -= nums[i];
        }
    }

    static void sol(int n) throws IOException {
        func(0, 2 * n - 1, n, 0);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(Math.abs(2 * bestHalf - valueSum)));
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        nums = new int[2 * n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2 * n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            valueSum += nums[i];
        }
        bestHalf = valueSum;

        sol(n);
        br.close();
    }
}
