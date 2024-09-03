/*
 * dp[r][c]: (r,c)에서 끝날때 최대방문칸수
 * (r, c, value) 의 n^2 크기 리스트를 저장하고 value 순으로 정렬
 * value가 가장 작은 원소부터 해당 r,c의 dp를 갱신한다
 */
package lim.DP;

import java.util.*;
import java.io.*;

public class 격자_안에서_한_칸씩_전진하는_DP_정수_사각형_최장_증가_수열 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] dp, grid;
    static int[] drs = { 1, -1, 0, 0 };
    static int[] dcs = { 0, 0, 1, -1 };
    static ArrayList<Pos> positions = new ArrayList<>();

    static class Pos {
        int r, c, value;

        Pos(int r, int c, int value) {
            this.r = r;
            this.c = c;
            this.value = value;
        }
    }

    static boolean inRange(int r, int c) {
        return r > 0 && c > 0 && r < grid.length && c < grid.length;
    }

    static void sol() throws IOException {
        for (Pos pos : positions) {
            for (int i = 0; i < dcs.length; i++) {
                int nr = pos.r + drs[i];
                int nc = pos.c + dcs[i];
                if (!inRange(nr, nc)) {
                    continue;
                }
                int nextValue = grid[nr][nc];
                if (pos.value >= nextValue) {
                    continue;
                }
                dp[nr][nc] = Math.max(dp[nr][nc], dp[pos.r][pos.c] + 1);
            }
        }

        int answer = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp.length; j++) {
                answer = Math.max(answer, dp[i][j]);
            }
        }
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        dp = new int[n + 1][n + 1];
        grid = new int[n + 1][n + 1];
        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < n + 1; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = 1;
                positions.add(new Pos(i, j, grid[i][j]));
            }
        }
        positions.sort((p1, p2) -> p1.value - p2.value);
        sol();
        br.close();
    }
}
