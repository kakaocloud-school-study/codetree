package lim.BFS;

import java.util.*;
import java.io.*;

public class 골드5_16928_뱀과_사다리_게임 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] moveTo;

    static class Item {
        int x, t;

        Item(int x, int t) {
            this.x = x;
            this.t = t;
        }
    }

    static int bfs(int sX) {
        LinkedList<Item> queue = new LinkedList<>();
        boolean[] visited = new boolean[moveTo.length];
        visited[sX] = true;
        queue.offer(new Item(sX, 0));

        while (!queue.isEmpty()) {
            Item item = queue.poll();
            if (item.x == 100) {
                return item.t;
            }

            for (int dice = 1; dice <= 6; dice++) {
                int nX = item.x + dice;
                if (nX >= moveTo.length) {
                    continue;
                }
                if (moveTo[nX] != 0) {
                    nX = moveTo[nX];
                }
                if (visited[nX]) {
                    continue;
                }
                visited[nX] = true;
                queue.add(new Item(nX, item.t + 1));
            }
        }
        return -1;
    }

    static void sol() throws IOException {
        bw.write(bfs(1) + "");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        moveTo = new int[101];
        for (int i = 0; i < n + m; i++) {
            st = new StringTokenizer(br.readLine());
            moveTo[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }

        sol();

        br.close();
        bw.flush();
        bw.close();
    }
}
