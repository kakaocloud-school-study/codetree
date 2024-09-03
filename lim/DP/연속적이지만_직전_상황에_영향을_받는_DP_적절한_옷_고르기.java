package lim.DP;

import java.util.*;
import java.io.*;

public class 연속적이지만_직전_상황에_영향을_받는_DP_적절한_옷_고르기 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] dp;
    static Item[] items;
    static int n, m;

    static class Item {
        int s, e, val;

        Item(int s, int e, int val) {
            this.s = s;
            this.e = e;
            this.val = val;
        }

        boolean isValid(int time) {
            return s <= time && time <= e;
        }
    }

    static void sol(int num) throws IOException {
        for (int time = 2; time <= m; time++) {
            for (int currItemIdx = 0; currItemIdx < items.length; currItemIdx++) {
                Item currItem = items[currItemIdx];
                if (!currItem.isValid(time)) {
                    continue;
                }
                for (int prevItemIdx = 0; prevItemIdx < items.length; prevItemIdx++) {
                    Item prevItem = items[prevItemIdx];
                    if (!prevItem.isValid(time - 1)) {
                        continue;
                    }
                    int absValue = Math.abs(currItem.val - prevItem.val);
                    dp[currItemIdx][time] = Math.max(dp[currItemIdx][time], dp[prevItemIdx][time - 1] + absValue);
                }
            }
        }

        int answer = 0;
        for (int itemIdx = 0; itemIdx < items.length; itemIdx++) {
            answer = Math.max(answer, dp[itemIdx][m]);
        }
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        dp = new int[n + 1][m + 1];
        items = new Item[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            items[i] = new Item(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()));
        }
        sol(n);
        br.close();
    }
}
