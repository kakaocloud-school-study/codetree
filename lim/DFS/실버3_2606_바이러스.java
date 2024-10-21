package lim.DFS;

import java.util.*;
import java.io.*;

public class 실버3_2606_바이러스 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    static int dfs(int node, boolean[] visited) {
        visited[node] = true;
        int count = 1;
        for (int nextNode : graph.get(node)) {
            if (visited[nextNode]) {
                continue;
            }
            count += dfs(nextNode, visited);
        }
        return count;
    }

    static void sol() throws IOException {
        bw.write(dfs(1, new boolean[n + 1]) - 1 + "");
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < m; i++) {
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
