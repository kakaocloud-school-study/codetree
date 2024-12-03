package lim.BFS;

import java.util.*;
import java.io.*;

public class 실버1_1697_숨바꼭질 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, k;

    static class Item {
        int x, t;

        Item(int x, int t) {
            this.x = x;
            this.t = t;
        }
    }

    static int bfs(int sX) {
        LinkedList<Item> queue = new LinkedList<>();
        boolean[] visited = new boolean[200_000];
        visited[sX] = true;
        queue.offer(new Item(sX, 0));

        while (!queue.isEmpty()) {
            Item item = queue.poll();
            if (item.x == k) {
                return item.t;
            }

            int[] nXs = new int[] { item.x - 1, item.x + 1, item.x * 2 };
            for (int nX : nXs) {
                if (nX < 0 || nX >= visited.length || visited[nX]) {
                    continue;
                }
                visited[nX] = true;
                queue.add(new Item(nX, item.t + 1));
            }
        }
        return -1;
    }

    static void sol() throws IOException {
        bw.write(bfs(n) + "");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        sol();

        br.close();
        bw.flush();
        bw.close();
    }
}
