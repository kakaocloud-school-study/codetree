package lim.트리;

import java.util.*;
import java.io.*;

public class Tree_DP_노드의_정수_계산 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
    static int[] values, dp;

    static int func(int node) {
        if (dp[node] != -1) {
            return dp[node];
        }
        int value = values[node];
        for (int nextNode : tree.get(node)) {
            value += func(nextNode);
        }
        if (value < 0) {
            value = 0;
        }
        dp[node] = value;
        return value;
    }

    static void sol() throws IOException {
        int answer = func(1);
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] signs = { -1, 1 };
        dp = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            tree.add(new ArrayList<>());
            dp[i] = -1;
        }
        values = new int[n + 1];

        for (int node = 2; node < n + 1; node++) {
            st = new StringTokenizer(br.readLine());
            int sign = signs[Integer.parseInt(st.nextToken())];
            int value = Integer.parseInt(st.nextToken());
            int parent = Integer.parseInt(st.nextToken());
            values[node] = sign * value;
            tree.get(parent).add(node);
        }
        sol();
        br.close();
    }
}
