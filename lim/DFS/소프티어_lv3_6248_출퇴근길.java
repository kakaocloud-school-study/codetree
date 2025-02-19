package lim.DFS;

import java.io.*;
import java.util.*;

public class 소프티어_lv3_6248_출퇴근길 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int src, dest;
    static ArrayList<ArrayList<Integer>> inGraph = new ArrayList<>();
    static ArrayList<ArrayList<Integer>> outGraph = new ArrayList<>();

    static void dfs(int node, int passNode, ArrayList<ArrayList<Integer>> graph, HashSet<Integer> visited) {
        if (node == passNode) {
            return;
        }
        for (int nNode : graph.get(node)) {
            if (visited.contains(nNode)) {
                continue;
            }
            visited.add(nNode);
            dfs(nNode, passNode, graph, visited);
        }
    }

    static HashSet<Integer> findVisited(int src, int dest) {
        HashSet<Integer> srcVisited = new HashSet<>();
        HashSet<Integer> destVisited = new HashSet<>();

        dfs(src, dest, outGraph, srcVisited);
        dfs(dest, 0, inGraph, destVisited);

        HashSet<Integer> intersection = new HashSet<>();
        for (int node : srcVisited) {
            if (destVisited.contains(node)) {
                intersection.add(node);
            }
        }
        intersection.remove(src);
        intersection.remove(dest);
        return intersection;
    }

    static void sol() throws IOException {
        HashSet<Integer> visited1 = findVisited(src, dest);
        HashSet<Integer> visited2 = findVisited(dest, src);
        HashSet<Integer> intersection = new HashSet<>();
        for (int node : visited1) {
            if (visited2.contains(node)) {
                intersection.add(node);
            }
        }
        bw.write(intersection.size() + "");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n + 1; i++) {
            inGraph.add(new ArrayList<>());
            outGraph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            outGraph.get(s).add(e);
            inGraph.get(e).add(s);
        }
        st = new StringTokenizer(br.readLine());
        src = Integer.parseInt(st.nextToken());
        dest = Integer.parseInt(st.nextToken());

        sol();

        br.close();
        bw.flush();
        bw.close();
    }
}
