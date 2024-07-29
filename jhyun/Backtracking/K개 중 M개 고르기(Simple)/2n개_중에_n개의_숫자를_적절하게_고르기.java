import java.util.*;
import java.io.*;

public class Main {
    static final int INT_MAX = Integer.MAX_VALUE;
    static final int MAX_N = 10;

    static int n;
    static int[] num = new int[2 * MAX_N];
    static boolean[] visited = new boolean[2 * MAX_N];

    static int ans = INT_MAX;

    static int calc() {
        int diff = 0;
        for (int i = 0; i < 2 * n; i++) {
            if (visited[i]) {
                diff += num[i];
            } else {
                diff -= num[i];
            }
        }
        return Math.abs(diff);
    }

    static void findMin(int idx, int cnt) {
        if (cnt == n) {
            ans = Math.min(ans, calc());
            return;
        }

        if (idx == 2 * n) {
            return;
        }
        //현재 숫자를 첫 번째 그룹에 사용한 경우
        visited[idx] = true;
        findMin(idx + 1, cnt + 1);
        visited[idx] = false;

        //현재 숫자를 두 번째 그룹에 사용한 경우
        findMin(idx + 1, cnt);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2 * n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        findMin(0, 0);

        System.out.print(ans);
    }
}