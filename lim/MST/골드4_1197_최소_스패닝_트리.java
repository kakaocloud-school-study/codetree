package lim.MST;

import java.util.*;
import java.io.*;

public class 골드4_1197_최소_스패닝_트리 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, e;
    static int[][] edges;

    static class Cost implements Comparable<Cost> {
        int edgeIdx, dist;

        Cost(int edgeIdx, int dist) {
            this.edgeIdx = edgeIdx;
            this.dist = dist;
        }

        @Override
        public int compareTo(Cost cost) {
            return this.dist - cost.dist;
        }
    }

    static class UnionFind {
        int[] parents;

        UnionFind(int n) {
            parents = new int[n + 1];
            for (int i = 0; i < parents.length; i++) {
                parents[i] = i;
            }
        }

        int find(int child) {
            int node = child;
            while (parents[node] != node) {
                node = parents[node];
            }
            parents[child] = node;
            return node;
        }

        void union(int a, int b) {
            int aRoot = find(a);
            int bRoot = find(b);
            parents[aRoot] = bRoot;
        }

        boolean isUnion(int a, int b) {
            return find(a) == find(b);
        }
    }

    static void sol() throws IOException {
        Cost[] costs = new Cost[edges.length];
        for (int i = 0; i < costs.length; i++) {
            costs[i] = new Cost(i, edges[i][2]);
        }
        Arrays.sort(costs);

        UnionFind uf = new UnionFind(n);
        int answer = 0;
        for (Cost cost : costs) {
            int aNode = edges[cost.edgeIdx][0];
            int bNode = edges[cost.edgeIdx][1];
            if (uf.isUnion(aNode, bNode)) {
                continue;
            }
            uf.union(aNode, bNode);
            answer += cost.dist;
        }
        bw.write(answer + "");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        edges = new int[e][3];
        for (int i = 0; i < edges.length; i++) {
            st = new StringTokenizer(br.readLine());
            edges[i][0] = Integer.parseInt(st.nextToken());
            edges[i][1] = Integer.parseInt(st.nextToken());
            edges[i][2] = Integer.parseInt(st.nextToken());
        }
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}