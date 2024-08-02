package lim.트리;

import java.util.*;
import java.io.*;

public class 트리_트리의_부모_노드 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] parents;

    static void bfs() {
        LinkedList<Integer> queue = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        queue.offer(1);
        visited.add(1);

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

    static void sol() throws IOException {
        bfs();
        for (int i = 2; i < parents.length; i++) {
            bw.write(parents[i] + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        parents = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
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
