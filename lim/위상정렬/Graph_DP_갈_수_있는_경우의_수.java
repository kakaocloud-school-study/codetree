package lim.위상정렬;

import java.util.*;
import java.io.*;

public class Graph_DP_갈_수_있는_경우의_수 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static HashMap<Integer, ArrayList<Integer>> inGraph = new HashMap<>(), outGraph = new HashMap<>();
    static HashMap<Integer, Integer> inDegrees = new HashMap<>();
    static LinkedList<Integer> queue = new LinkedList<>();
    static int n, m;
    static int[] dp;

    static void sol() throws IOException {
        while (!queue.isEmpty()) {
            int node = queue.poll();
            if (node != 1) {
                for (int prevNode : inGraph.get(node)) {
                    dp[node] += dp[prevNode];
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
        int answer = dp[n];
        bw.write(answer + "");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        dp = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            inGraph.put(i, new ArrayList<>());
            outGraph.put(i, new ArrayList<>());
            inDegrees.put(i, 0);
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            inGraph.get(e).add(s);
            outGraph.get(s).add(e);

            inDegrees.put(e, inDegrees.get(e) + 1);
        }

        queue.add(1);
        dp[1] = 1;

        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}
