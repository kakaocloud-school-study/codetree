/*
 * 문제 순서 착각해서 이걸로 품...
 */
package lim.트리;

import java.util.*;
import java.util.Map.Entry;
import java.io.*;

public class 트리_트리의_지름3 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int answer = 0;
    static ArrayList<HashMap<Integer, Integer>> graph = new ArrayList<>();

    static class Item {
        int node, depth;

        Item(int node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    static Item bfs(int root, HashSet<Integer> visited) {
        LinkedList<Item> queue = new LinkedList<>();
        queue.offer(new Item(root, 0));
        visited.add(root);

        Item maxDepthItem = queue.peek();
        while (!queue.isEmpty()) {
            Item item = queue.poll();
            if (maxDepthItem.depth < item.depth) {
                maxDepthItem = item;
            }
            for (Entry<Integer, Integer> entry : graph.get(item.node).entrySet()) {
                int nextNode = entry.getKey();
                int dist = entry.getValue();
                if (visited.contains(nextNode)) {
                    continue;
                }
                visited.add(nextNode);
                queue.add(new Item(nextNode, item.depth + dist));
            }
        }
        return maxDepthItem;
    }

    static void sol() throws IOException {

        int root = 1;
        HashSet<Integer> visited = new HashSet<>();
        Item startItem = bfs(root, visited);
        visited.clear();
        Item endItem = bfs(startItem.node, visited);

        visited.clear();
        visited.add(startItem.node);
        Item item = bfs(endItem.node, visited);
        visited.clear();
        visited.add(startItem.node);
        item = bfs(item.node, visited);
        answer = Math.max(answer, item.depth);

        visited.clear();
        visited.add(endItem.node);
        item = bfs(startItem.node, visited);
        visited.clear();
        visited.add(endItem.node);
        item = bfs(item.node, visited);
        answer = Math.max(answer, item.depth);

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n + 1; i++) {
            graph.add(new HashMap<>());
        }
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            graph.get(s).put(e, dist);
            graph.get(e).put(s, dist);
        }
        sol();
        br.close();
    }
}
