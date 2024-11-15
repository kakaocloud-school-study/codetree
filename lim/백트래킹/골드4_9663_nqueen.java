/*
 * 이미 놓은 row번호, 이미 놓은 대각선 역대각선 번호를 각각 기록하고 가지치기하며 재귀한다
 * HashSet 쓰니까 메모리초과됨... 이론적으로는 가능할텐데 오버헤드가 있는듯
 * 
 */

package lim.백트래킹;

import java.util.*;
import java.io.*;

public class 골드4_9663_nqueen {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;

    static int getCaseCount(int cIdx, boolean[] rows, boolean[] slashes,
            boolean[] reversedSlashes) {
        if (cIdx == n) {
            return 1;
        }

        int count = 0;
        for (int rIdx = 0; rIdx < n; rIdx++) {
            if (rows[rIdx] || slashes[n - 1 - rIdx + cIdx] || reversedSlashes[rIdx + cIdx]) {
                continue;
            }

            rows[rIdx] = true;
            slashes[n - 1 - rIdx + cIdx] = true;
            reversedSlashes[rIdx + cIdx] = true;

            count += getCaseCount(cIdx + 1, rows, slashes, reversedSlashes);

            rows[rIdx] = false;
            slashes[n - 1 - rIdx + cIdx] = false;
            reversedSlashes[rIdx + cIdx] = false;
        }
        return count;
    }

    static void sol() throws IOException {
        bw.write(getCaseCount(0, new boolean[n], new boolean[2 * n - 1], new boolean[2 * n - 1]) + "");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}
