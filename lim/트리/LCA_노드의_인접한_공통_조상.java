package lim.트리;

import java.util.*;
import java.io.*;

public class LCA_노드의_인접한_공통_조상 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, root, nodeA, nodeB;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static final int MAX_HEIGHT = 10000, MAX_HOPS = 13;
    static int[] depths;
    static int[][] parents;

    static class Item {
        int node, depth;

        Item(int node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    static void initParents() {
        for (int hops = 1; hops <= MAX_HOPS; hops++) {// 이중 포문 중첩 순서 유의
            for (int node = 1; node < n + 1; node++) {
                if (parents[hops - 1][node] == 0 || parents[hops - 1][parents[hops - 1][node]] == 0) {
                    continue;
                }
                parents[hops][node] = parents[hops - 1][parents[hops - 1][node]];
            }
        }
    }

    static void bfs(int root) {
        LinkedList<Item> queue = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        queue.offer(new Item(root, 0));
        visited.add(root);

        while (!queue.isEmpty()) {
            Item item = queue.poll();
            depths[item.node] = item.depth;
            for (int nextNode : graph.get(item.node)) {
                if (visited.contains(nextNode)) {
                    continue;
                }
                visited.add(nextNode);
                queue.add(new Item(nextNode, item.depth + 1));

            }
        }
    }

    static void sol() throws IOException {
        initParents();
        int root = 1;
        while (parents[0][root] != 0) {
            root = parents[0][root];
        }
        bfs(root);

        if (depths[nodeA] < depths[nodeB]) {
            int tmp = nodeA;
            nodeA = nodeB;
            nodeB = tmp;
        }
        int gap = depths[nodeA] - depths[nodeB];
        while (gap > 0) {
            for (int hops = MAX_HOPS; hops >= 0; hops--) {
                if ((1 << hops) > gap) {
                    continue;
                }
                nodeA = parents[hops][nodeA];
                gap -= 1 << hops;
            }
        }
        while (nodeA != nodeB) {
            for (int hops = MAX_HOPS; hops >= 0; hops--) {
                if (parents[hops][nodeA] == parents[hops][nodeB]) {
                    continue;
                }
                nodeA = parents[hops][nodeA];
                nodeB = parents[hops][nodeB];
            }
            nodeA = parents[0][nodeA];
            nodeB = parents[0][nodeB];
        }

        bw.write(nodeA + "");
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        parents = new int[MAX_HOPS + 1][n + 1];
        depths = new int[n + 1];

        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            parents[0][c] = p;
            graph.get(p).add(c);
        }
        st = new StringTokenizer(br.readLine());
        nodeA = Integer.parseInt(st.nextToken());
        nodeB = Integer.parseInt(st.nextToken());

        sol();
        br.close();
    }
}
