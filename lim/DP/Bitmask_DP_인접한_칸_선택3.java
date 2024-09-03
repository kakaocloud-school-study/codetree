/*
 * 시간 복잡도 초과하지 않나??
 * 근데 통과된다
 */
package lim.DP;

import java.util.*;
import java.io.*;

public class Bitmask_DP_인접한_칸_선택3 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m, k, MAX_MASK;
    static int[][][] dp; // 인덱스, 마스크, 지금까지 고른수
    static int[][] grid;

    static int getCount(int mask) {
        int count = 0;
        int prev = -1;
        while (mask != 0) {
            if (prev == (mask & 1) && prev == 1) {
                return -1;
            }
            prev = mask & 1;
            count += prev;
            mask /= 2;
        }
        return count;
    }

    static int sumLine(int rIdx, int mask) {
        int valueSum = 0;
        for (int i = 0; i < m; i++) {
            if ((mask & (1 << i)) == 0) {
                continue;
            }
            valueSum += grid[rIdx][i];
        }
        return valueSum;
    }

    static void sol() throws IOException {
        ArrayList<Integer> masks = new ArrayList<>();
        for (int mask = 0; mask < MAX_MASK + 1; mask++) {
            int count = getCount(mask);
            if (count == -1 || count > k) {
                continue;
            }
            masks.add(mask);
        }
        for (int mask : masks) {
            int count = getCount(mask);
            dp[0][mask][count] = sumLine(0, mask);
        }
        for (int i = 0; i < dp.length - 1; i++) {
            for (int mask : masks) {
                for (int nextMask : masks) {
                    if ((mask & nextMask) != 0) {
                        continue;
                    }
                    int nextAdded = getCount(nextMask);
                    for (int count = 0; count + nextAdded < k + 1; count++) {
                        if (dp[i][mask][count] == -1) {
                            continue;
                        }
                        dp[i + 1][nextMask][count + nextAdded] = Math.max(
                                dp[i + 1][nextMask][count + nextAdded],
                                dp[i][mask][count] + sumLine(i + 1, nextMask));
                    }
                }
            }
        }
        int answer = 0;
        for (int mask = 0; mask < MAX_MASK + 1; mask++) {
            for (int count = 0; count < k + 1; count++) {
                answer = Math.max(answer, dp[n - 1][mask][count]);
            }
        }
        bw.write(answer + "");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        MAX_MASK = (1 << m) - 1;
        dp = new int[n][MAX_MASK + 1][k + 1];
        grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}
