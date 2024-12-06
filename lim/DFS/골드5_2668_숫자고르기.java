package lim.DFS;

import java.util.*;
import java.io.*;

public class 골드5_2668_숫자고르기 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] nums;

    static boolean dfs(int sNode, int node, int depth, HashSet<Integer> visited) {
        if (sNode == node && depth != 0) {
            return true;
        }
        if (visited.contains(node)) {
            return false;
        }
        visited.add(node);

        return dfs(sNode, nums[node], depth + 1, visited);
    }

    static void sol() throws IOException {
        HashSet<Integer> cycleNums = new HashSet<>();
        for (int i = 1; i < nums.length; i++) {
            HashSet<Integer> visited = new HashSet<>();
            if (dfs(i, i, 0, visited)) {
                cycleNums.addAll(visited);
            }
        }

        bw.write(cycleNums.size() + "\n");
        for (int num : new TreeSet<>(cycleNums)) {
            bw.write(num + "\n");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        nums = new int[n + 1];
        for (int i = 1; i < nums.length; i++) {
            st = new StringTokenizer(br.readLine());
            nums[i] = Integer.parseInt(st.nextToken());
        }
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}
