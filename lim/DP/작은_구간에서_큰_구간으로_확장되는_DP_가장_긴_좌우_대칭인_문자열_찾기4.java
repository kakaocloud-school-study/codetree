package lim.DP;

// import java.util.*;
import java.io.*;

public class 작은_구간에서_큰_구간으로_확장되는_DP_가장_긴_좌우_대칭인_문자열_찾기4 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] arr;
    static Boolean[][] dp;

    static boolean func(int s, int e) {
        if (s > e) {
            return true;
        }
        if (s == e) {
            dp[s][e] = true;
            return dp[s][e];
        }
        if (dp[s][e] != null) {
            return dp[s][e];
        }

        boolean subValue = func(s + 1, e - 1);
        if (subValue && arr[s] == arr[e]) {
            dp[s][e] = true;
        } else {
            dp[s][e] = false;
        }
        return dp[s][e];
    }

    static void sol(int num) throws IOException {
        int answer = 0;
        for (int gap = 0; gap < arr.length; gap++) {
            for (int i = 0; i + gap < arr.length; i++) {
                if (func(i, i + gap)) {
                    answer = gap + 1;
                }
            }
        }
        bw.write(answer + "");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        int n = word.length();
        dp = new Boolean[n][n];
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = word.charAt(i);
        }
        sol(n);
        br.close();
        bw.flush();
        bw.close();
    }
}
