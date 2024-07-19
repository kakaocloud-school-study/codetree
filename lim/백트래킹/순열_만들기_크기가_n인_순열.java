package lim.백트래킹;

import java.util.*;
import java.io.*;

public class 순열_만들기_크기가_n인_순열 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static HashSet<Integer> selected = new HashSet<>();

    private static void func(int n, int m, ArrayList<Integer> arr) throws IOException {
        if (m == arr.size()) {
            for (int num : arr) {
                bw.write(num + " ");
            }
            bw.newLine();
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (selected.contains(i)) {
                continue;
            }
            arr.add(i);
            selected.add(i);
            func(n, m, arr);
            arr.remove(arr.size() - 1);
            selected.remove(i);
        }
    }

    private static void sol(int n) throws IOException {
        func(n, n, new ArrayList<>());
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        sol(n);
        br.close();
    }
}
