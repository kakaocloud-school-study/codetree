package lim.트리;

import java.util.*;
import java.io.*;

public class 골드3_2533_사회망_서비스 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int[] parents;
    static int[][] dp;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    static void setPatents(int parent) {
        for (int child : graph.get(parent)) {
            if (child == parents[parent]) {
                continue;
            }
            parents[child] = parent;
            setPatents(child);
        }
    }

    static int dfs(int node, int early) {
        if (dp[node][early] != Integer.MAX_VALUE) {
            return dp[node][early];
        }

        int count = early;

        for (int nextNode : graph.get(node)) {
            if (nextNode == parents[node]) {
                continue;
            }

            if (early == 1) {
                count += Math.min(dfs(nextNode, 0), dfs(nextNode, 1));
            } else {
                count += dfs(nextNode, 1);
            }
        }

        dp[node][early] = count;
        return count;
    }

    static void sol() throws IOException {
        parents = new int[n + 1];
        setPatents(1);
        dp = new int[n + 1][2]; // i번째 노드가 j일때(얼리아답타 유무) 해당 노드 아래에 서브트리의 최소 얼리어답타 수
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        bw.write(Math.min(dfs(1, 0), dfs(1, 1)) + "");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph.get(s).add(e);
            graph.get(e).add(s);
        }
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}