package lim.위상정렬;

import java.util.*;
import java.io.*;

public class Graph_DP_선행_작업 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static HashMap<Integer, ArrayList<Integer>> inGraph = new HashMap<>(), outGraph = new HashMap<>();
    static HashMap<Integer, Integer> inDegrees = new HashMap<>();
    static LinkedList<Integer> queue = new LinkedList<>();
    static int n;
    static int[] dp, costs;

    static void sol() throws IOException {
        while (!queue.isEmpty()) {
            int node = queue.poll();
            dp[node] = costs[node];
            for (int prevNode : inGraph.get(node)) {
                dp[node] = Math.max(dp[node], costs[node] + dp[prevNode]);
            }
            for (int nextNode : outGraph.get(node)) {
                int degree = inDegrees.get(nextNode);
                degree--;
                inDegrees.put(nextNode, degree);
                if (degree == 0) {
                    queue.offer(nextNode);
                }
            }
        }
        int answer = 0;
        for (int i = 1; i < dp.length; i++) {
            answer = Math.max(answer, dp[i]);
        }
        bw.write(answer + "");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        dp = new int[n + 1];
        costs = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            inGraph.put(i, new ArrayList<>());
            outGraph.put(i, new ArrayList<>());
        }

        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken());
            int prevCount = Integer.parseInt(st.nextToken());
            for (int j = 0; j < prevCount; j++) {
                int prevNode = Integer.parseInt(st.nextToken());
                inGraph.get(i).add(prevNode);
                outGraph.get(prevNode).add(i);
            }
            costs[i] = cost;
            inDegrees.put(i, prevCount);
            if (prevCount == 0) {
                queue.offer(i);
            }
        }

        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}
