/*
 * 문제 자체는 중복없는 조합을 dp로 푸는 문제
 * 하지만 시간 복잡도 계산이 의문스러움
 */
package lim.미분류;

import java.util.*;
import java.io.*;

public class 동전_분배_골드2_1943 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, MAX_MONEY = 100_000;
    static int[] prices;
    static int[] coinCounts;
    static boolean[] dp;

    static int getValueSum() {
        int valueSum = 0;
        for (int i = 0; i < prices.length; i++) {
            valueSum += prices[i] * coinCounts[i];
        }
        return valueSum;
    }

    static void sol() throws IOException {
        int valueSum = getValueSum();
        if (valueSum % 2 == 1) {
            bw.write("0\n");
            return;
        }
        int halfSum = valueSum / 2;

        dp[0] = true;
        for (int i = 0; i < prices.length; i++) {
            for (int currMoney = halfSum; currMoney > 0; currMoney--) {
                for (int count = 0; count <= coinCounts[i]; count++) {
                    int prevMoney = currMoney - prices[i] * count;
                    if (prevMoney < 0) { // 이 코드가 당락을 결정했음... 왜????
                        break;
                    }
                    if (dp[prevMoney]) {
                        dp[currMoney] = true;
                    }
                }
            }
        }

        if (dp[halfSum]) {
            bw.write("1\n");
            return;
        }
        bw.write("0\n");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        prices = new int[n];
        coinCounts = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int price = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());
            prices[i] = price;
            coinCounts[i] = count;
        }
        dp = new boolean[MAX_MONEY + 1];
        sol();

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        prices = new int[n];
        coinCounts = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int price = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());
            prices[i] = price;
            coinCounts[i] = count;
        }
        dp = new boolean[MAX_MONEY + 1];
        sol();

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        prices = new int[n];
        coinCounts = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int price = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());
            prices[i] = price;
            coinCounts[i] = count;
        }
        dp = new boolean[MAX_MONEY + 1];
        sol();

        bw.flush();
        bw.close();
    }
}