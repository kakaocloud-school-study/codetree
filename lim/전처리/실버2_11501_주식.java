package lim.전처리;

import java.util.*;
import java.io.*;

public class 실버2_11501_주식 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] stocks;

    static void sol() throws IOException {
        int[] maxAtRight = new int[stocks.length];
        int maxVal = 0;
        for (int i = maxAtRight.length - 1; i >= 0; i--) {
            maxVal = Math.max(stocks[i], maxVal);
            maxAtRight[i] = maxVal;
        }

        long total = 0;
        for (int i = 0; i < maxAtRight.length; i++) {
            total += maxAtRight[i] - stocks[i];
        }
        bw.write(total + "\n");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());

        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            stocks = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < stocks.length; i++) {
                stocks[i] = Integer.parseInt(st.nextToken());
            }
            sol();
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
