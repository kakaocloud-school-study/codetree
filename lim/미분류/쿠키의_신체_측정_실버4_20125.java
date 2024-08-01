package lim.미분류;

import java.util.*;
import java.io.*;

public class 쿠키의_신체_측정_실버4_20125 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] grid;
    static int n;
    static int[] drs = { 1, 0, -1, 0 };
    static int[] dcs = { 0, 1, 0, -1 };
    static Pos heartPos;

    static class Pos {
        int r, c, depth;

        Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static Pos findHeart() {
        for (int i = 1; i < grid.length - 1; i++) {
            for (int j = 1; j < grid.length - 1; j++) {
                if (grid[i][j] == 1 && grid[i + 1][j] == 1 && grid[i - 1][j] == 1 && grid[i][j + 1] == 1
                        && grid[i][j - 1] == 1) {
                    return new Pos(i, j);
                }
            }
        }
        return null;
    }

    static boolean inRange(int r, int c) {
        return r >= 0 && c >= 0 && r < n && c < n;
    }

    static int getCountByDir(int direction, int r, int c) {
        int count = 0;
        while (inRange(r, c) && grid[r][c] == 1) {
            count++;
            r = r + drs[direction];
            c = c + dcs[direction];
        }
        return count;
    }

    static void sol() throws IOException {
        heartPos = findHeart();
        int leftArm = getCountByDir(3, heartPos.r, heartPos.c - 1);
        int rightArm = getCountByDir(1, heartPos.r, heartPos.c + 1);
        int waist = getCountByDir(0, heartPos.r + 1, heartPos.c);
        int leftLeg = getCountByDir(0, heartPos.r + waist + +1, heartPos.c - 1);
        int rightLeg = getCountByDir(0, heartPos.r + waist + 1, heartPos.c + 1);

        bw.write((heartPos.r + 1) + " " + (heartPos.c + 1) + "\n");
        bw.write(leftArm + " " + rightArm + " " + waist + " " + leftLeg + " " + rightLeg);
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String[] words = st.nextToken().split("");
            for (int j = 0; j < n; j++) {
                String word = words[j];
                if ("_".equals(word)) {
                    grid[i][j] = 0;
                } else {
                    grid[i][j] = 1;
                }
            }
        }

        sol();
        br.close();
    }
}
