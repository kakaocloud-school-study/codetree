package lim.DP;

import java.util.*;
import java.io.*;

public class String_Matching_최장_공통_부분_수열3 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m;
    static Item[][] dp;
    static Pos[][] prevPositions;
    static int[] arr1, arr2;

    static class Pos {
        int r, c;

        Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static class Item {
        int len, lastCommon;

        Item(int len, int lastCommon) {
            this.len = len;
            this.lastCommon = lastCommon;
        }
    }

    static void sol() throws IOException {
        prevPositions = new Pos[dp.length][dp[0].length];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                prevPositions[i][j] = new Pos(0, 0);
            }
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (arr1[i] == arr2[j] && (dp[i][j].len < dp[i - 1][j - 1].len + 1)) {
                    dp[i][j].len = dp[i - 1][j - 1].len + 1;
                    dp[i][j].lastCommon = arr1[i];
                    prevPositions[i][j].r = i - 1;
                    prevPositions[i][j].c = j - 1;
                }
                if (dp[i][j].len < dp[i - 1][j].len
                        || (dp[i][j].len == dp[i - 1][j].len
                                && dp[i][j].lastCommon > dp[i - 1][j].lastCommon)) {
                    dp[i][j].len = dp[i - 1][j].len;
                    dp[i][j].lastCommon = dp[i - 1][j].lastCommon;
                    prevPositions[i][j].r = i - 1;
                    prevPositions[i][j].c = j;
                }
                if (dp[i][j].len < dp[i][j - 1].len
                        || (dp[i][j].len == dp[i][j - 1].len
                                && dp[i][j].lastCommon > dp[i][j - 1].lastCommon)) {
                    dp[i][j].len = dp[i][j - 1].len;
                    dp[i][j].lastCommon = dp[i][j - 1].lastCommon;
                    prevPositions[i][j].r = i;
                    prevPositions[i][j].c = j - 1;
                }
            }
        }

        ArrayList<Integer> lcs = new ArrayList<>();
        Pos pos = new Pos(prevPositions.length - 1, prevPositions[0].length - 1);
        while (pos.r > 0 && pos.c > 0) {
            Pos prevPos = prevPositions[pos.r][pos.c];
            if (pos.r - 1 == prevPos.r && pos.c - 1 == prevPos.c && arr1[pos.r] == arr2[pos.c]) {
                lcs.add(arr1[pos.r]);
            }
            pos = prevPos;
        }

        for (int i = lcs.size() - 1; i >= 0; i--) {
            bw.write(lcs.get(i) + " ");
        }

        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr1 = new int[n + 1];
        for (int i = n; i >= 0; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        arr2 = new int[m + 1];
        for (int i = m; i >= 0; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }
        dp = new Item[n + 1][m + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = new Item(0, Integer.MAX_VALUE);
            }
        }
        sol();
        br.close();
    }
}
