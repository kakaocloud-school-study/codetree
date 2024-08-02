/*
 * 해설과 다른 풀이
 * 해설에서는 트리 지름으로 풀지만
 * 여기에선 그래프 차수를 이용하여 품
 */
package lim.트리;

import java.util.*;
import java.io.*;

public class 트리_트리_최적의_노드 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] degrees;
    static int answer;
    static ArrayList<HashSet<Integer>> graph = new ArrayList<>();
    static ArrayList<HashSet<Integer>> graphOrigin = new ArrayList<>();

    static class Item {
        int node, depth;

        Item(int node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    static void bfs(int root) {
        LinkedList<Item> queue = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        queue.offer(new Item(root, 0));
        visited.add(root);

        while (!queue.isEmpty()) {
            Item item = queue.poll();
            answer = Math.max(answer, item.depth);
            for (int nextNode : graphOrigin.get(item.node)) {
                if (visited.contains(nextNode)) {
                    continue;
                }
                visited.add(nextNode);
                queue.add(new Item(nextNode, item.depth + 1));
            }
        }
    }

    static void sol() throws IOException {
        HashSet<Integer> parents = new HashSet<>();
        ArrayList<Integer> leafs = new ArrayList<>();
        for (int node = 1; node < degrees.length; node++) {
            if (degrees[node] > 1) {
                parents.add(node);
            } else if (degrees[node] == 1) {
                leafs.add(node);
            }
        }
        while (parents.size() > 1) {
            ArrayList<Integer> newLeafs = new ArrayList<>();
            for (int leaf : leafs) {
                int adjNode = graph.get(leaf).iterator().next();
                graph.get(leaf).remove(adjNode);
                graph.get(adjNode).remove(leaf);
                degrees[leaf]--;
                degrees[adjNode]--;
                if (degrees[adjNode] == 1) {
                    newLeafs.add(adjNode);
                    parents.remove(adjNode);
                }
            }
            leafs = newLeafs;
        }

        int root = 1;
        for (int node = 1; node < degrees.length; node++) {
            if (degrees[node] > degrees[root]) {
                root = node;
            }
        }

        bfs(root);

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        degrees = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            graph.add(new HashSet<>());
            graphOrigin.add(new HashSet<>());
        }
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph.get(s).add(e);
            graph.get(e).add(s);
            graphOrigin.get(s).add(e);
            graphOrigin.get(e).add(s);
            degrees[s]++;
            degrees[e]++;
        }
        sol();
        br.close();
    }
}
