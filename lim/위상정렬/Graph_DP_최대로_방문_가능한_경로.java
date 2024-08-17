/*
 * 뒤집어서 n -> 1로 가는 간선으로 만들어 풀이
 * 이전 서브 경로 n ~> i의 경로들 중 경로가 최대며 직전 노드 값이 제일 작은 것을 고르면 최장 사전순 경로가 구해짐
 */
package lim.위상정렬;

import java.util.*;
import java.io.*;

public class Graph_DP_최대로_방문_가능한_경로 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static HashMap<Integer, ArrayList<Integer>> inGraph = new HashMap<>(), outGraph = new HashMap<>();
    static HashMap<Integer, Integer> inDegrees = new HashMap<>();
    static LinkedList<Integer> queue = new LinkedList<>();
    static int n, m;
    static int[] dp, path;

    static void sol() throws IOException {
        while (!queue.isEmpty()) {
            int node = queue.poll();
            int maxPathPrevNode = -1;
            for (int prevNode : inGraph.get(node)) {
                if (dp[prevNode] == -1) {
                    continue;
                }
                if (maxPathPrevNode == -1) {
                    dp[node] = dp[prevNode] + 1;
                    maxPathPrevNode = prevNode;
                    path[node] = prevNode;
                    continue;
                }
                if (dp[node] < dp[prevNode] + 1) {
                    dp[node] = dp[prevNode] + 1;
                    maxPathPrevNode = prevNode;
                    path[node] = prevNode;
                    continue;
                }
                if (dp[node] == dp[prevNode] + 1 && maxPathPrevNode > prevNode) {
                    dp[node] = dp[prevNode] + 1;
                    maxPathPrevNode = prevNode;
                    path[node] = prevNode;
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
        bw.write(dp[1] + "\n");
        if (dp[1] == -1) {
            return;
        }
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        int cur = 1;
        while (path[cur] != 0) {
            arr.add(path[cur]);
            cur = path[cur];
        }
        for (int i = 0; i < arr.size(); i++) {
            bw.write(arr.get(i) + " ");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        dp = new int[n + 1];
        path = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            dp[i] = -1;
        }
        for (int i = 1; i < n + 1; i++) {
            inGraph.put(i, new ArrayList<>());
            outGraph.put(i, new ArrayList<>());
            inDegrees.put(i, 0);
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int e = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            inGraph.get(e).add(s);
            outGraph.get(s).add(e);

            inDegrees.put(e, inDegrees.get(e) + 1);
        }

        for (int i = 1; i < n + 1; i++) {
            if (inDegrees.get(i) == 0) {
                queue.add(i);
            }
        }
        dp[n] = 1;

        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}
