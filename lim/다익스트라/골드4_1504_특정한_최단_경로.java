package lim.다익스트라;

import java.util.*;
import java.io.*;

public class 골드4_1504_특정한_최단_경로 {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, e, aNode, bNode;
    static int[] dists;
    static ArrayList<ArrayList<Cost>> graph = new ArrayList<>();

    static class Cost implements Comparable<Cost> {
        int node, dist;

        public Cost(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }

        @Override
        public int compareTo(Cost cost) {
            return this.dist - cost.dist;
        }
    }

    static void initDists() {
        for (int i = 0; i < dists.length; i++) {
            dists[i] = Integer.MAX_VALUE;
        }
    }

    static void dijkstra(int sNode) {
        PriorityQueue<Cost> queue = new PriorityQueue<>();
        queue.offer(new Cost(sNode, 0));
        dists[sNode] = 0;

        while (!queue.isEmpty()) {
            Cost curr = queue.poll();
            if (curr.dist > dists[curr.node]) {
                continue;
            }
            for (Cost nCost : graph.get(curr.node)) {
                int nDist = curr.dist + nCost.dist;
                if (nDist >= dists[nCost.node]) {
                    continue;
                }
                dists[nCost.node] = nDist;
                queue.offer(new Cost(nCost.node, nDist));
            }
        }
    }

    static void sol() throws IOException {
        int answer = Integer.MAX_VALUE;
        initDists();
        dijkstra(1);
        int saDist = dists[aNode];
        int sbDist = dists[bNode];

        initDists();
        dijkstra(aNode);
        int abDist = dists[bNode];
        int aeDist = dists[n];

        initDists();
        dijkstra(bNode);
        int beDist = dists[n];

        if (saDist != Integer.MAX_VALUE && abDist != Integer.MAX_VALUE && beDist != Integer.MAX_VALUE) {
            answer = Math.min(answer, saDist + abDist + beDist);
        }

        if (sbDist != Integer.MAX_VALUE && abDist != Integer.MAX_VALUE && aeDist != Integer.MAX_VALUE) {
            answer = Math.min(answer, sbDist + abDist + aeDist);
        }

        if (answer == Integer.MAX_VALUE) {
            answer = -1;
        }

        bw.write(answer + "");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        dists = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            graph.get(s).add(new Cost(e, dist));
            graph.get(e).add(new Cost(s, dist));
        }
        st = new StringTokenizer(br.readLine());
        aNode = Integer.parseInt(st.nextToken());
        bNode = Integer.parseInt(st.nextToken());
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}