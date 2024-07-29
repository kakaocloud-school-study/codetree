package lim.DP;

import java.util.*;
import java.io.*;

public class String_Matching_최장_공통_부분_수열2 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] dp;
    static Pos[][] prevPositions;
    static String[] str1, str2;

    static class Pos {
        int r, c;

        Pos(int r, int c) {
            this.r = r;
            this.c = c;
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
                if (str1[i - 1].equals(str2[j - 1]) && dp[i][j] < dp[i - 1][j - 1] + 1) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    prevPositions[i][j].r = i - 1;
                    prevPositions[i][j].c = j - 1;
                }
                if (dp[i][j] < dp[i - 1][j]) {
                    dp[i][j] = dp[i - 1][j];
                    prevPositions[i][j].r = i - 1;
                    prevPositions[i][j].c = j;
                }
                if (dp[i][j] < dp[i][j - 1]) {
                    dp[i][j] = dp[i][j - 1];
                    prevPositions[i][j].r = i;
                    prevPositions[i][j].c = j - 1;
                }
            }
        }

        ArrayList<String> lcs = new ArrayList<>();
        Pos pos = new Pos(prevPositions.length - 1, prevPositions[0].length - 1);
        while (pos.r > 0 && pos.c > 0) {
            Pos prevPos = prevPositions[pos.r][pos.c];
            if (pos.r - 1 == prevPos.r && pos.c - 1 == prevPos.c && str1[pos.r - 1].equals(str2[pos.c - 1])) {
                lcs.add(str1[pos.r - 1]);
            }
            pos = prevPos;
        }

        for (int i = lcs.size() - 1; i >= 0; i--) {
            bw.write(lcs.get(i));
        }

        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        str1 = st.nextToken().split("");
        st = new StringTokenizer(br.readLine());
        str2 = st.nextToken().split("");
        dp = new int[str1.length + 1][str2.length + 1];
        sol();
        br.close();
    }
}
