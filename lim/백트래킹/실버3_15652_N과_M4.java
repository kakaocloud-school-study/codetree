package lim.백트래킹;

import java.util.*;
import java.io.*;

public class 실버3_15652_N과_M4 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static void func(int n, int m, ArrayList<Integer> arr, ArrayList<ArrayList<Integer>> result) {
        if (arr.size() == m) {
            result.add(new ArrayList<>(arr));
            return;
        }

        int startNum;
        if (arr.isEmpty()) {
            startNum = 1;
        } else {
            startNum = arr.get(arr.size() - 1);
        }

        for (int num = startNum; num <= n; num++) {
            arr.add(num);
            func(n, m, arr, result);
            arr.remove(arr.size() - 1);
        }
    }

    static void sol(int n, int m) throws IOException {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        func(n, m, new ArrayList<>(), result);
        for (ArrayList<Integer> arr : result) {
            for (int num : arr) {
                bw.write(num + " ");
            }
            bw.write("\n");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        sol(n, m);
        br.close();
        bw.flush();
        bw.close();
    }
}
