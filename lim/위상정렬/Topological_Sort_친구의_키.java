package lim.위상정렬;

import java.util.*;
import java.io.*;

public class Topological_Sort_친구의_키 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static boolean[] visited;
    static ArrayList<HashSet<Integer>> graph = new ArrayList<>();
    static int n, m;
    static int sNode;

    static void dfs(int node, ArrayList<Integer> stack) {
        for (int nextNode : graph.get(node)) {
            if (visited[nextNode]) {
                continue;
            }
            visited[nextNode] = true;
            dfs(nextNode, stack);
        }
        stack.add(node);
    }

    static void sol(int n) throws IOException {
        ArrayList<Integer> stack = new ArrayList<>();
        dfs(sNode, stack);
        for (int i = stack.size() - 1; i >= 0; i--) {
            bw.write(stack.get(i) + " ");
        }
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n + 1; i++) {
            graph.add(new HashSet<>());
        }
        visited = new boolean[n + 1];

        HashSet<Integer> biggers = new HashSet<>();
        for (int i = 1; i < n + 1; i++) {
            biggers.add(i);
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            biggers.remove(b);
        }

        sNode = biggers.iterator().next();

        sol(n);
        br.close();
    }
}
