package lim.트리;

import java.util.*;
import java.io.*;

public class Tree_DP_트리의_서브트리 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, root, q;
    static int[] dp, parents, queries;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    static void bfs() {
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

    static int func(int node) {
        if (dp[node] != -1) {
            return dp[node];
        }
        int count = 1;
        for (int nextNode : graph.get(node)) {
            if (parents[nextNode] != node) {
                continue;
            }
            count += func(nextNode);
        }
        dp[node] = count;
        return count;
    }

    static void sol() throws IOException {
        bfs();
        for (int subRoot : queries) {
            int result = func(subRoot);
            bw.write(result + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        root = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());
        parents = new int[n + 1];
        dp = new int[n + 1];
        queries = new int[q];

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

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            queries[i] = Integer.parseInt(st.nextToken());
        }

        sol();
        br.close();
    }
}
