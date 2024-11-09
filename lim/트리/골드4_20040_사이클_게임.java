package lim.트리;

import java.util.*;
import java.io.*;

public class 골드4_20040_사이클_게임 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int[][] edges;

    static class UnionFind {
        int[] parents;

        UnionFind(int n) {
            parents = new int[n];
            for (int i = 0; i < parents.length; i++) {
                parents[i] = i;
            }
        }

        int find(int node) {
            if (parents[node] == node) {
                return node;
            }
            int root = find(parents[node]);
            parents[node] = root;
            return root;
        }

        boolean isUnion(int aNode, int bNode) {
            return find(aNode) == find(bNode);
        }

        void union(int aNode, int bNode) {
            int aRoot = find(aNode);
            int bRoot = find(bNode);
            parents[aRoot] = bRoot;
        }
    }

    static void sol() throws IOException {
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < edges.length; i++) {
            if (uf.isUnion(edges[i][0], edges[i][1])) {
                bw.write(i + 1 + "");
                return;
            }
            uf.union(edges[i][0], edges[i][1]);
        }
        bw.write("0");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        edges = new int[m][2];
        for (int i = 0; i < edges.length; i++) {
            st = new StringTokenizer(br.readLine());
            edges[i] = new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };
        }
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}