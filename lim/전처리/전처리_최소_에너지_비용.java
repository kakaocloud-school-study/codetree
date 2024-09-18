package lim.전처리;

import java.util.*;
import java.io.*;

public class 전처리_최소_에너지_비용 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int[] costs, prices;

    static void sol() throws IOException {
        long minPrice = prices[0];
        long answer = minPrice * costs[0];
        for (int i = 1; i < costs.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            answer += minPrice * costs[i];
        }
        bw.write(answer + "");
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        costs = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n - 1; i++) {
            costs[i] = Integer.parseInt(st.nextToken());
        }

        prices = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            prices[i] = Integer.parseInt(st.nextToken());
        }
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}
