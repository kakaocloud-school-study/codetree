package lim.백트래킹;

import java.util.*;
import java.io.*;

public class 실버2_15663_N과_M_9 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m;
    static int[] nums;

    static void perm(int n, int m, ArrayList<Integer> arr, HashSet<Integer> visited,
            ArrayList<ArrayList<Integer>> result) {
        if (arr.size() == m) {
            result.add(new ArrayList<>(arr));
            return;
        }

        int prev = -1;
        for (int i = 0; i < n; i++) {
            if (visited.contains(i)) {
                continue;
            }
            if (prev != -1 && nums[prev] == nums[i]) {
                continue;
            }

            arr.add(i);
            visited.add(i);

            perm(n, m, arr, visited, result);

            arr.remove(arr.size() - 1);
            visited.remove(i);

            prev = i;
        }
    }

    static void sol() throws IOException {
        Arrays.sort(nums);

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        perm(n, m, new ArrayList<>(), new HashSet<>(), result);

        for (ArrayList<Integer> arr : result) {
            for (int idx : arr) {
                bw.write(nums[idx] + " ");
            }
            bw.write("\n");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        nums = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}
