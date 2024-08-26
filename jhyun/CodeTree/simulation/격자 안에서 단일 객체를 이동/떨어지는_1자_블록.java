import java.util.*;
import java.io.*;

public class Main {
    static final int MAX_N = 100;
    static final int DIR_NUM = 4;

    static int n;
    static int m, k;
    static int[][] grid = new int[MAX_N][MAX_N];

    //해당 row[colS, colE] 열에 전부 블럭이 없는지를 확인
    static boolean allBlank(int row, int colS, int colE) {
        for (int col = colS; col <= colE; col++) {
            if (grid[row][col] > 0) {
                return false;
            }
        }
        return true;
    }


    //최종적으로 도달하게 될 위치는 그 다음 위치에 최초로 블럭이 존재하는 순간임을 이용
    static int getTargetRow() {
        for (int row = 0; row < n - 1; row++) {
            if (!allBlank(row + 1, k, k + m - 1)) {
                return row;
            }
        }
        return n - 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken()) - 1;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int targetRow = getTargetRow();

        for (int col = k; col < k + m; col++) {
            grid[targetRow][col] = 1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}