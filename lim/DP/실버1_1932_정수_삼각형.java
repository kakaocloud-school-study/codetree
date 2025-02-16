package lim.DP;

import java.util.*;
import java.io.*;

public class 실버1_1932_정수_삼각형 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] triangle;

    static void sol() throws IOException {
        for (int i = 1; i < triangle.length; i++) {
            for (int j = 0; j <= i; j++) {
                int maxPrevSum = Integer.MIN_VALUE;
                if (j > 0) {
                    maxPrevSum = Math.max(maxPrevSum, triangle[i - 1][j - 1]);
                }
                if (j < i) {
                    maxPrevSum = Math.max(maxPrevSum, triangle[i - 1][j]);
                }
                triangle[i][j] += maxPrevSum;
            }
        }
        int maxPrevSum = Integer.MIN_VALUE;
        for (int i = 0; i < triangle.length; i++) {
            maxPrevSum = Math.max(maxPrevSum, triangle[triangle.length - 1][i]);
        }
        bw.write(maxPrevSum + "");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        triangle = new int[n][n];
        for (int i = 0; i < triangle.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}