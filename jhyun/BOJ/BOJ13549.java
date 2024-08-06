package jhyun.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ13549 {
    static final int MAX_N = 100_000;
    static int[] dx = {-1, 1};
    static int n, k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        bfs(n, k);
    }

    private static void bfs(int start, int dist) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[MAX_N + 1];
        queue.add(new int[]{start, 0});
        visited[start] = true;

        while (!queue.isEmpty()) {
            int[] position = queue.poll();
            int pos = position[0];
            int move = position[1];
            if (pos == dist) {
                System.out.println(move);
                return;
            }
            int jump = pos * 2;
            if (jump < MAX_N + 1 && !visited[jump]) {
                visited[jump] = true;
                queue.add(new int[]{jump, move});
            }

            for (int i = 0; i < 2; i++) {
                int next = pos + dx[i];
                if (next >= 0 && next < MAX_N + 1 && !visited[next]) {
                    visited[next] = true;
                    queue.add(new int[]{next, move + 1});
                }
            }
        }
    }
}