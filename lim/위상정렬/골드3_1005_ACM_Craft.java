package lim.위상정렬;

import java.util.*;
import java.io.*;

public class 골드3_1005_ACM_Craft {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] delays;
    static int[][] edges;
    static int w;

    static class Item implements Comparable<Item> {
        int node, endAt;

        Item(int node, int endAt) {
            this.node = node;
            this.endAt = endAt;
        }

        @Override
        public int compareTo(Item o) {
            return this.endAt - o.endAt;
        }
    }

    static void sol() throws IOException {
        int[] inDegree = new int[delays.length];
        ArrayList<ArrayList<Integer>> outGraph = new ArrayList<>();
        PriorityQueue<Item> queue = new PriorityQueue<>();
        int currTime = 0;
        for (int i = 0; i < inDegree.length; i++) {
            outGraph.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int s = edges[i][0];
            int e = edges[i][1];
            outGraph.get(s).add(e);
            inDegree[e]++;
        }

        for (int node = 1; node < inDegree.length; node++) {
            if (inDegree[node] == 0) {
                queue.offer(new Item(node, currTime + delays[node]));
            }
        }

        while (!queue.isEmpty()) {
            Item item = queue.poll();
            currTime = item.endAt;
            if (item.node == w) {
                bw.write(currTime + "\n");
                return;
            }

            for (int nextNode : outGraph.get(item.node)) {
                inDegree[nextNode]--;
                if (inDegree[nextNode] == 0) {
                    queue.offer(new Item(nextNode, currTime + delays[nextNode]));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            delays = new int[n + 1];
            for (int j = 1; j < delays.length; j++) {
                delays[j] = Integer.parseInt(st.nextToken());
            }

            edges = new int[k][2];
            for (int j = 0; j < edges.length; j++) {
                st = new StringTokenizer(br.readLine());
                edges[j][0] = Integer.parseInt(st.nextToken());
                edges[j][1] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());

            sol();
        }
        br.close();
        bw.flush();
        bw.close();
    }
}