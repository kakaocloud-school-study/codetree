package lim.MST;

import java.util.*;
import java.io.*;

public class Prim_도시_연결하기 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m;
    static int[][] grid;
    static int[] dists, drs = { 1, 0, -1, 0 }, dcs = { 0, 1, 0, -1 };
    static ArrayList<HashMap<Integer, Integer>> graph = new ArrayList<>();

    static class Item {
        int node, dist;

        Item(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    static class Pos {
        int r, c;

        Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static void prim() {
        PriorityQueue<Item> queue = new PriorityQueue<>((it1, it2) -> it1.dist - it2.dist);
        boolean[] visited = new boolean[dists.length];
        queue.offer(new Item(1, 0));
        dists[1] = 0;

        while (!queue.isEmpty()) {
            Item item = queue.poll();
            if (item.dist > dists[item.node]) {
                continue;
            }
            visited[item.node] = true;

            for (Map.Entry<Integer, Integer> e : graph.get(item.node).entrySet()) {
                int nextNode = e.getKey();
                int cost = e.getValue();
                if (dists[nextNode] > cost && !visited[nextNode]) {
                    dists[nextNode] = cost;
                    queue.offer(new Item(nextNode, dists[nextNode]));
                }
            }
        }
    }

    static boolean inRange(int r, int c) {
        return r >= 0 && c >= 0 && r < n && c < m;
    }

    static Pos getEndPos(int r, int c, int direction) {
        int dist = 0;
        int nr = r + drs[direction] * dist;
        int nc = c + dcs[direction] * dist;
        while (inRange(nr, nc) && grid[nr][nc] == 0) {
            dist++;
            nr = r + drs[direction] * dist;
            nc = c + dcs[direction] * dist;
        }
        if (!inRange(nr, nc)) {
            return null;
        }
        return new Pos(nr, nc);
    }

    static void setBridge(int r, int c) {
        if (grid[r][c] > 0) {
            return;
        }
        Pos left = getEndPos(r, c, 3), right = getEndPos(r, c, 1), up = getEndPos(r, c, 2), down = getEndPos(r, c, 0);
        if (left != null && right != null && grid[left.r][left.c] != grid[right.r][right.c]) {
            int len = Math.abs(left.c - right.c) - 1;
            int node1 = grid[left.r][left.c];
            int node2 = grid[right.r][right.c];
            if (graph.get(node1).get(node2) == null || graph.get(node1).get(node2) > len) {
                graph.get(node1).put(node2, len);
                graph.get(node2).put(node1, len);
            }
        }
        if (up != null && down != null && grid[up.r][up.c] != grid[down.r][down.c]) {
            int len = Math.abs(up.r - down.r) - 1;
            int node1 = grid[up.r][up.c];
            int node2 = grid[down.r][down.c];
            if (graph.get(node1).get(node2) == null || graph.get(node1).get(node2) > len) {
                graph.get(node1).put(node2, len);
                graph.get(node2).put(node1, len);
            }
        }
    }

    static void bfs(boolean[][] visited, int cityNum, int r, int c) {
        LinkedList<Pos> queue = new LinkedList<>();
        queue.offer(new Pos(r, c));
        visited[r][c] = true;

        while (!queue.isEmpty()) {
            Pos pos = queue.poll();
            grid[pos.r][pos.c] = cityNum;
            for (int i = 0; i < drs.length; i++) {
                int nr = pos.r + drs[i];
                int nc = pos.c + dcs[i];
                if (!inRange(nr, nc) || visited[nr][nc] || grid[nr][nc] == 0) {
                    continue;
                }
                visited[nr][nc] = true;
                queue.offer(new Pos(nr, nc));
            }
        }
    }

    static void sol() throws IOException {
        int cityNum = 1;
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (visited[i][j] || grid[i][j] == 0) {
                    continue;
                }
                bfs(visited, cityNum++, i, j);
            }
        }

        for (int i = 0; i < cityNum; i++) {
            graph.add(new HashMap<>());
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                setBridge(i, j);
            }
        }

        dists = new int[cityNum];

        for (int i = 0; i < cityNum; i++) {
            dists[i] = Integer.MAX_VALUE;
        }

        prim();

        int answer = 0;
        for (int node = 1; node < dists.length; node++) {
            answer += dists[node];
            if (dists[node] == Integer.MAX_VALUE) {
                bw.write("-1");
                return;
            }
        }
        bw.write(answer + "");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        sol();

        bw.flush();
        bw.close();
        br.close();
    }
}