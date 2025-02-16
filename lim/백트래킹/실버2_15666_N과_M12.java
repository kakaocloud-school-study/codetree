package lim.백트래킹;

import java.util.*;
import java.io.*;

public class 실버2_15666_N과_M12 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static void func(int n, int m, ArrayList<Integer> arr, ArrayList<Integer> idxs,
            ArrayList<ArrayList<Integer>> result) {
        if (idxs.size() == m) {
            result.add(new ArrayList<>(idxs));
            return;
        }

        int startNum = 0;
        if (!idxs.isEmpty()) {
            startNum = arr.get(idxs.get(idxs.size() - 1));
        }
        HashSet<Integer> visitedNums = new HashSet<>();
        for (int idx = 0; idx < n; idx++) {
            int num = arr.get(idx);
            if (startNum > num || visitedNums.contains(num)) {
                continue;
            }
            visitedNums.add(num);

            idxs.add(idx);
            func(n, m, arr, idxs, result);
            idxs.remove(idxs.size() - 1);
        }
    }

    static void sol(int n, int m, ArrayList<Integer> arr) throws IOException {
        Collections.sort(arr);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        func(n, m, arr, new ArrayList<>(), result);
        for (ArrayList<Integer> idxs : result) {
            for (int idx : idxs) {
                bw.write(arr.get(idx) + " ");
            }
            bw.write("\n");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<Integer> arr = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }
        sol(n, m, arr);
        br.close();
        bw.flush();
        bw.close();
    }
}
