package lim.다익스트라;

import java.util.*;
import java.io.*;

public class Dijkstra_천_개의_정거장 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, aNode, bNode;
    static final int MAX_NODE = 1000;
    static Cost[] dists;
    static Cost[][] grid;

    static class Cost implements Comparable<Cost> {
        long money;
        int time;

        public Cost(long money, int time) {
            this.money = money;
            this.time = time;
        }

        void setZero() {
            money = 0;
            time = 0;
        }

        Cost plus(Cost cost) {
            return new Cost(money + cost.money, time + cost.time);
        }

        boolean isInit() {
            return money == Long.MAX_VALUE && time == Integer.MAX_VALUE;
        }

        @Override
        public int compareTo(Cost cost) {
            if (this.money == cost.money) {
                return this.time - cost.time;
            }
            return this.money < cost.money ? -1 : 1;
        }
    }

    static void dijkstra(int sNode) {
        HashSet<Integer> visited = new HashSet<>();
        dists[sNode].setZero();
        for (int unused = 0; unused < dists.length; unused++) {
            int selectedNode = -1;
            for (int node = 1; node < dists.length; node++) {
                if (visited.contains(node)) {
                    continue;
                }
                if (selectedNode == -1 || dists[node].compareTo(dists[selectedNode]) < 0) {
                    selectedNode = node;
                }
            }
            if (selectedNode == -1 || dists[selectedNode].isInit()) {
                break;
            }

            for (int nNode = 1; nNode < dists.length; nNode++) {
                Cost cost = grid[selectedNode][nNode];
                if (cost.isInit()) {
                    continue;
                }
                Cost nCost = dists[selectedNode].plus(cost);
                if (nCost.compareTo(dists[nNode]) < 0) {
                    dists[nNode] = nCost;
                }
            }

            visited.add(selectedNode);
        }
    }

    static void sol() throws IOException {
        dijkstra(aNode);
        if (dists[bNode].isInit()) {
            bw.write("-1 -1");
            return;
        }
        bw.write(dists[bNode].money + " " + dists[bNode].time);
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        aNode = Integer.parseInt(st.nextToken());
        bNode = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        dists = new Cost[MAX_NODE + 1];
        grid = new Cost[MAX_NODE + 1][MAX_NODE + 1];
        for (int i = 0; i < dists.length; i++) {
            dists[i] = new Cost(Long.MAX_VALUE, Integer.MAX_VALUE);
        }
        for (int i = 0; i < MAX_NODE + 1; i++) {
            for (int j = 0; j < MAX_NODE + 1; j++) {
                grid[i][j] = new Cost(Long.MAX_VALUE, Integer.MAX_VALUE);
            }
        }

        for (int unused = 0; unused < n; unused++) {
            st = new StringTokenizer(br.readLine());
            int money = Integer.parseInt(st.nextToken());
            int nodeCount = Integer.parseInt(st.nextToken());
            int[] nodes = new int[nodeCount];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < nodes.length; i++) {
                nodes[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < nodes.length; i++) {
                int s = nodes[i];
                for (int j = i + 1; j < nodes.length; j++) {
                    int e = nodes[j];
                    Cost nCost = new Cost(money, j - i);
                    if (nCost.compareTo(grid[s][e]) < 0) {
                        grid[s][e] = nCost;
                    }
                }
            }
        }
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}