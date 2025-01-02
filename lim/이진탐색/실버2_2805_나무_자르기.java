package lim.이진탐색;

import java.util.*;
import java.io.*;

public class 실버2_2805_나무_자르기 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int goal;
    static int[] trees;

    static boolean check(int h) {
        long total = 0;
        for (int tree : trees) {
            total += Math.max(0, tree - h);
        }
        return total >= goal;
    }

    static void sol() throws IOException {
        int lo = 0, hi = 2_000_000_000;
        int answer = lo;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (check(mid)) {
                lo = mid + 1;
                answer = mid;
            } else {
                hi = mid - 1;
            }
        }
        bw.write(answer + "");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        goal = Integer.parseInt(st.nextToken());

        trees = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < trees.length; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }

        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}