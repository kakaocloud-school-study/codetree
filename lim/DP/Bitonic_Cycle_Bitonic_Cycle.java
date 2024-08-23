package lim.DP;

import java.util.*;
import java.io.*;

public class Bitonic_Cycle_Bitonic_Cycle {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static long[][] dp;
    static Pos[] positions;

    static class Pos {
        int x, y;

        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }

        long getDist(Pos pos) {
            return (long) (Math.pow(this.x - pos.x, 2) + Math.pow(this.y - pos.y, 2));
        }
    }

    static void sol() throws IOException {
        for (int i = 0; i < dp.length - 1; i++) {
            for (int j = 0; j < dp[0].length - 1; j++) {
                if (dp[i][j] == Long.MAX_VALUE) {
                    continue;
                }
                int nextIdx = Math.max(i, j) + 1;
                Pos iPos = positions[i];
                Pos jPos = positions[j];
                Pos nextPos = positions[nextIdx];
                dp[nextIdx][j] = Math.min(dp[nextIdx][j], dp[i][j] + iPos.getDist(nextPos));
                dp[i][nextIdx] = Math.min(dp[i][nextIdx], dp[i][j] + jPos.getDist(nextPos));
            }
        }
        long answer = Long.MAX_VALUE;
        for (int i = 0; i < dp.length; i++) {
            Pos iPos = positions[i];
            Pos goalPos = positions[n - 1];
            answer = Math.min(answer, dp[i][n - 1] + iPos.getDist(goalPos));
        }
        bw.write(answer + "");
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        dp = new long[n][n];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = Long.MAX_VALUE;
            }
        }
        dp[0][0] = 0;
        positions = new Pos[n];
        for (int i = 0; i < positions.length; i++) {
            st = new StringTokenizer(br.readLine());
            positions[i] = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(positions, (p1, p2) -> p1.x - p2.x);
        sol();
        br.close();
    }
}
