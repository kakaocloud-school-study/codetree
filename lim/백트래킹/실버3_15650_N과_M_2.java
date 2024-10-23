package lim.백트래킹;

import java.util.*;
import java.io.*;

public class 실버3_15650_N과_M_2 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m;

    static void comb(int n, int m, ArrayList<Integer> arr, ArrayList<ArrayList<Integer>> result) {
        if (arr.size() == m) {
            result.add(new ArrayList<>(arr));
            return;
        }

        int startNum = 1;
        if (!arr.isEmpty()) {
            startNum = arr.get(arr.size() - 1) + 1;
        }
        for (int i = startNum; i < n + 1; i++) {
            arr.add(i);
            comb(n, m, arr, result);
            arr.remove(arr.size() - 1);
        }
    }

    static void sol() throws IOException {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        comb(n, m, new ArrayList<>(), result);

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
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}
