/*
 * 좌표압축 + 투포인터
 * 문제 정의가 좀 거지같다. 길이 4짜리로 위치 4와 위치 8이 모두 커버되는 정의
 */
package lim.미분류;

import java.util.*;
import java.io.*;

public class 하늘에서_별똥별이_빗발친다_골드3_14658 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m, l, k;
    static int[][] grid, stars;
    static ArrayList<Integer> rows = new ArrayList<>(), cols = new ArrayList<>();

    static boolean isUnderLimit(ArrayList<Integer> rowsOrCols, int idx1, int idx2) {
        return rowsOrCols.get(idx2) - rowsOrCols.get(idx1) <= l;
    }

    static void sol() throws IOException {
        int answer = 0;
        for (int i = 0; i < grid.length; i++) {
            int total = 0;
            int eRIdx = 0;
            int eCIdx = 0;
            for (int j = 0; j < grid[0].length; j++) {
                while (eRIdx < grid.length && isUnderLimit(rows, i, eRIdx)) {
                    for (int k = j; k < eCIdx; k++) {
                        total += grid[eRIdx][k];
                    }
                    eRIdx++;
                }
                while (eCIdx < grid[0].length && isUnderLimit(cols, j, eCIdx)) {
                    for (int k = i; k < eRIdx; k++) {
                        total += grid[k][eCIdx];
                    }
                    eCIdx++;
                }

                answer = Math.max(answer, total);

                for (int k = i; k < eRIdx; k++) {
                    total -= grid[k][j];
                }
            }
        }
        bw.write((k - answer) + "");
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        stars = new int[k][2];
        HashSet<Integer> rowSet = new HashSet<>();
        HashSet<Integer> colSet = new HashSet<>();
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            stars[i][0] = r;
            stars[i][1] = c;
            rowSet.add(r);
            colSet.add(c);
        }
        for (int row : rowSet) {
            rows.add(row);
        }
        for (int col : colSet) {
            cols.add(col);
        }
        rows.sort(Comparator.naturalOrder());
        cols.sort(Comparator.naturalOrder());

        grid = new int[rows.size()][cols.size()];

        for (int i = 0; i < k; i++) {
            int r = stars[i][0];
            int c = stars[i][1];
            int rIdx = 0;
            for (int j = 0; j < rows.size(); j++) {
                if (rows.get(j) == r) {
                    rIdx = j;
                    break;
                }
            }
            int cIdx = 0;
            for (int j = 0; j < cols.size(); j++) {
                if (cols.get(j) == c) {
                    cIdx = j;
                    break;
                }
            }
            grid[rIdx][cIdx] = 1;
        }

        sol();
        br.close();
    }
}

/*
 * 50 50 4 7
 * 1 6
 * 2 1
 * 3 3
 * 10 7
 * 12 6
 * 13 9
 * 14 8
 * ->3
 * 
 * 10 10 3 6
 * 1 1
 * 1 2
 * 1 3
 * 1 4
 * 1 5
 * 1 6
 * ->2
 */