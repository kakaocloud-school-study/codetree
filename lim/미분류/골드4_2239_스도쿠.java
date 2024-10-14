/*
 * 시간 복잡도 계산이 불가함
 * 언뜻 시간 내에 불가능해 보이지만 가지치기가 많은 재귀라서 가능하다
 */
package lim.미분류;

import java.util.*;
import java.io.*;

public class 골드4_2239_스도쿠 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] grid = new int[9][9];
    static ArrayList<Blank> blanks = new ArrayList<>();

    static class Blank {
        int r, c;

        Blank(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static boolean func(int idx) {
        if (idx == blanks.size()) {
            return true;
        }

        int r = blanks.get(idx).r;
        int c = blanks.get(idx).c;

        boolean[] visited = new boolean[10];
        for (int i = 0; i < grid.length; i++) {
            visited[grid[i][c]] = true;
            visited[grid[r][i]] = true;
        }
        for (int i = r - (r % 3); i < r - (r % 3) + 3; i++) {
            for (int j = c - (c % 3); j < c - (c % 3) + 3; j++) {
                visited[grid[i][j]] = true;
            }
        }
        for (int k = 1; k < visited.length; k++) {
            if (visited[k]) {
                continue;
            }
            grid[r][c] = k;
            if (func(idx + 1)) {
                return true;
            }
            grid[r][c] = 0;
        }

        return false;
    }

    static void sol() throws IOException {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    blanks.add(new Blank(i, j));
                }
            }
        }

        func(0);

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                bw.write(grid[i][j] + "");
            }
            bw.write("\n");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < grid.length; i++) {
            String[] nums = br.readLine().split("");
            for (int j = 0; j < grid[0].length; j++) {
                grid[i][j] = Integer.parseInt(nums[j]);
            }
        }
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}