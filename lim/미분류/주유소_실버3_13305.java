package lim.미분류;

import java.util.*;
import java.io.*;

public class 주유소_실버3_13305 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static long[] dists, prices;
    static int n;

    static void sol() throws IOException {
        long currMinVal = Long.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            currMinVal = Math.min(currMinVal, prices[i]);
            prices[i] = currMinVal;
        }

        long totalCost = 0;
        for (int i = 0; i < dists.length; i++) {
            totalCost += dists[i] * prices[i];
        }
        bw.write(String.valueOf(totalCost));
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        dists = new long[n];
        prices = new long[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n - 1; i++) {
            dists[i] = Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            prices[i] = Long.parseLong(st.nextToken());
        }

        sol();
        br.close();
    }
}
