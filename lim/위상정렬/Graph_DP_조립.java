package lim.위상정렬;

import java.util.*;
import java.io.*;

public class Graph_DP_조립 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static HashMap<Integer, HashMap<Integer, Integer>> inGraph = new HashMap<>();
    static HashMap<Integer, ArrayList<Integer>> outGraph = new HashMap<>();
    static HashMap<Integer, Integer> inDegrees = new HashMap<>();
    static LinkedList<Integer> queue = new LinkedList<>();
    static int n, m;
    static int[][] dp; // dp[i번째][조각번호j] i번을 만들기 위해 필요한 j조각 개수

    static void sol() throws IOException {
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (Map.Entry<Integer, Integer> e : inGraph.get(node).entrySet()) {
                int prevNode = e.getKey();
                int reqNum = e.getValue();
                for (int i = 1; i < n + 1; i++) {
                    dp[node][i] += dp[prevNode][i] * reqNum;
                }
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
        for (int i = 1; i < n + 1; i++) {
            if (dp[n][i] == 0) {
                continue;
            }
            bw.write(i + " " + dp[n][i] + "\n");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        dp = new int[n + 1][n + 1];
        for (int i = 1; i < n + 1; i++) {
            inGraph.put(i, new HashMap<>());
            outGraph.put(i, new ArrayList<>());
            inDegrees.put(i, 0);
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int e = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            inGraph.get(e).put(s, inGraph.get(e).getOrDefault(s, 0) + num);
            outGraph.get(s).add(e);

            inDegrees.put(e, inDegrees.get(e) + 1);
        }

        for (int i = 1; i < n + 1; i++) {
            int inDegree = inDegrees.get(i);
            if (inDegree == 0) {
                queue.offer(i);
                dp[i][i] = 1;
            }
        }

        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}
