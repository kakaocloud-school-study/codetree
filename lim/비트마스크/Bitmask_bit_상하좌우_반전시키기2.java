/*
 * 첫번째 행의 비트에대해 2^m 경우의 수만큼 시도한다. 둘째 행 이하부터 그리드풀이.
 * 2^m개 경우의 수를 구하기위해 재귀를 사용함
 * 해설에서는 위 부분을 0 ~ 0b1111111111 까지 for문으로 도는 식으로 간단하게 해결함
 * 즉, 비트마스크 경우의 수 조합은 그냥 숫자범위에 대해 for문 돌려 구할 수 있다.
 */
package lim.비트마스크;

import java.util.*;
import java.io.*;

public class Bitmask_bit_상하좌우_반전시키기2 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m, answer = Integer.MAX_VALUE;
    static int[] drs = { 1, 0, -1, 0, 0 }, dcs = { 0, 1, 0, -1, 0 };
    static int[][] grid;

    static boolean inRange(int r, int c) {
        return r >= 0 && c >= 0 && r < n && c < m;
    }

    static void toggle(int[][] grid, int r, int c) {
        for (int i = 0; i < dcs.length; i++) {
            int nr = r + drs[i], nc = c + dcs[i];
            if (!inRange(nr, nc)) {
                continue;
            }
            grid[nr][nc] ^= 1;
        }
    }

    static void check(int count) {
        int[][] tmp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                tmp[i][j] = grid[i][j];
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (tmp[i - 1][j] == 0) {
                    count++;
                    toggle(tmp, i, j);
                }
            }
        }

        for (int i = 0; i < m; i++) {
            if (tmp[n - 1][i] == 0) {
                return;
            }
        }
        answer = Math.min(answer, count);
    }

    static void func(int idx, int count) {
        if (idx == m) {
            check(count);
            return;
        }
        func(idx + 1, count);
        toggle(grid, 0, idx);
        func(idx + 1, count + 1);
        toggle(grid, 0, idx);
    }

    static void sol() throws IOException {
        func(0, 0);
        if (answer == Integer.MAX_VALUE) {
            answer = -1;
        }
        bw.write(answer + "");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
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
