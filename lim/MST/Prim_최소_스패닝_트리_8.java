package lim.MST;

import java.util.*;
import java.io.*;

public class Prim_최소_스패닝_트리_8 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m;
    static int[] dists;
    static ArrayList<HashMap<Integer, Integer>> graph = new ArrayList<>();

    static class Item {
        int node, dist;

        Item(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    static void prim() {
        PriorityQueue<Item> queue = new PriorityQueue<>((it1, it2) -> it1.dist - it2.dist);
        boolean[] visited = new boolean[n + 1];
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

    static void sol() throws IOException {
        prim();

        int answer = 0;
        for (int node = 1; node < dists.length; node++) {
            answer += dists[node];
        }
        bw.write(answer + "");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        dists = new int[n + 1];

        for (int i = 0; i < n + 1; i++) {
            dists[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < n + 1; i++) {
            graph.add(new HashMap<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            if (graph.get(s).get(e) == null || graph.get(s).get(e) > cost) {
                graph.get(s).put(e, cost);
                graph.get(e).put(s, cost);
            }
        }

        sol();

        bw.flush();
        bw.close();
        br.close();
    }
}