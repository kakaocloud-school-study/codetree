package lim.트리;

import java.util.*;
import java.io.*;

public class Tree_DP_중앙_노드 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, root, answer = 0;
    static int[] dp, parents;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    static void bfs() {
        parents = new int[n + 1];
        LinkedList<Integer> queue = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        queue.offer(root);
        visited.add(root);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int nextNode : graph.get(node)) {
                if (visited.contains(nextNode)) {
                    continue;
                }
                visited.add(nextNode);
                queue.add(nextNode);
                parents[nextNode] = node;
            }
        }
    }

    static int getTreeSize(int node) {
        if (dp[node] != -1) {
            return dp[node];
        }
        int count = 1;
        for (int nextNode : graph.get(node)) {
            if (parents[nextNode] != node) {
                continue;
            }
            count += getTreeSize(nextNode);
        }
        dp[node] = count;
        return count;
    }

    static int findMid(int node) {
        int prev = node;
        while (true) {
            prev = node;
            int count = 0;
            for (int nextNode : graph.get(prev)) {
                if (parents[nextNode] != prev) {
                    continue;
                }
                node = nextNode;
                count++;
            }
            if (count >= 2) {
                break;
            }
            if (count == 0) {
                break;
            }
        }
        return prev;
    }

    static void sol() throws IOException {
        bfs();
        root = findMid(root);
        bfs();

        int maxSize = Integer.MIN_VALUE;
        int minSize = Integer.MAX_VALUE;

        for (int node : graph.get(root)) {
            if (parents[node] != root) {
                continue;
            }
            int subSize = getTreeSize(node);
            maxSize = Math.max(maxSize, subSize);
            minSize = Math.min(minSize, subSize);
        }

        bw.write((maxSize - minSize) + "");
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        root = Integer.parseInt(st.nextToken());
        dp = new int[n + 1];

        for (int i = 0; i < n + 1; i++) {
            dp[i] = -1;
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph.get(s).add(e);
            graph.get(e).add(s);
        }

        sol();
        br.close();
    }
}
