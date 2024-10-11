package lim.다익스트라;

import java.util.*;
import java.io.*;

public class 플래4_1854_K번째_최단_경로 {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, e, k;
    static ArrayList<PriorityQueue<Integer>> dists = new ArrayList<>();
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
        for (PriorityQueue<Integer> queue : dists) {
            queue.clear();
        }
    }

    static void dijkstra(int sNode) {
        PriorityQueue<Cost> queue = new PriorityQueue<>();
        queue.offer(new Cost(sNode, 0));
        dists.get(sNode).offer(0);

        while (!queue.isEmpty()) {
            Cost curr = queue.poll();
            if (curr.dist > dists.get(curr.node).peek()) {
                continue;
            }
            for (Cost nCost : graph.get(curr.node)) {
                int nDist = curr.dist + nCost.dist;
                if (dists.get(nCost.node).size() == k && nDist >= dists.get(nCost.node).peek()) {
                    continue;
                }
                dists.get(nCost.node).offer(nDist);
                if (dists.get(nCost.node).size() > k) {
                    dists.get(nCost.node).poll();
                }
                queue.offer(new Cost(nCost.node, nDist));
            }
        }
    }

    static void sol() throws IOException {
        dijkstra(1);
        for (int node = 1; node < dists.size(); node++) {
            if (dists.get(node).size() < k) {
                bw.write("-1\n");
            } else {
                bw.write(dists.get(node).peek() + "\n");
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
            dists.add(new PriorityQueue<>((num1, num2) -> num2 - num1));
        }
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            graph.get(s).add(new Cost(e, dist));
        }
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}