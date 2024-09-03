package lim.트리;

import java.util.*;
import java.io.*;

public class Tree_DP_노드의_값 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, root, answer = 0;
    static int[] parents, values;
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

    static int[] func(int node) {
        int count = 1;
        int ops = 0;
        int valueSum = values[node];
        for (int nextNode : graph.get(node)) {
            if (parents[nextNode] != node) {
                continue;
            }
            int[] result = func(nextNode);
            int subCount = result[0];
            int subSum = result[2];
            int gap = Math.abs(subCount - subSum);
            ops += result[1];
            ops += gap;
            valueSum += subSum - subCount;
        }

        int[] result = { count, ops, valueSum };
        return result;
    }

    static void sol() throws IOException {
        bfs();

        bw.write(func(root)[1] + "");
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        root = 1;
        values = new int[n + 1];

        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            values[i] = Integer.parseInt(st.nextToken());
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
