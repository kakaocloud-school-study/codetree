import java.util.*;
import java.io.*;

public class Main {
    static final int INT_MAX = Integer.MAX_VALUE;
    static final int MAX_N = 10;

    static int n;
    static int[][] cost = new int[MAX_N][MAX_N];
    static boolean[] visited = new boolean[MAX_N];
    static List<Integer> picked = new ArrayList<>();

    static int ans = INT_MAX;

    static void findMin(int cnt) {
        if (cnt == n) {
            int totalCost = 0;
            for (int i = 0; i < picked.size() - 1; i++) {
                int currCost = cost[picked.get(i)][picked.get(i + 1)];
                //만약 비용이 0이라면 불가능한 경우
                if (currCost == 0) {
                    return;
                }
                totalCost += currCost;
            }

            int lastPos = picked.get(picked.size() - 1);
            int additionalCost = cost[lastPos][0];
            if (additionalCost == 0) {
                return;
            }

            ans = Math.min(ans, totalCost + additionalCost);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            picked.add(i);

            findMin(cnt + 1);

            visited[i] = false;
            picked.remove(picked.size() - 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited[0] = true;
        picked.add(0);
        findMin(1);

        System.out.print(ans);
    }
}