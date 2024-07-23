package lim.DP;

import java.util.*;
import java.io.*;

public class 조건에_맞게_선택적으로_전진하는_DP_겹치지_않게_선분_고르기_2 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] dp;
    static Pos[] positions;

    static class Pos {
        int s, e;

        Pos(int s, int e) {
            this.s = s;
            this.e = e;
        }
    }

    static void sol() throws IOException {
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (positions[i].s <= positions[j].e) {
                    continue;
                }
                dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }

        int answer = 1;
        for (int num : dp) {
            answer = Math.max(num, answer);
        }
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        dp = new int[n];
        positions = new Pos[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            positions[i] = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(positions, (p1, p2) -> p1.s - p2.s);
        sol();
        br.close();
    }
}