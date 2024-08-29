package lim.미분류;

import java.util.*;
import java.io.*;

public class 올림픽_실버5_8979 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, k;
    static Item[] items;

    static class Item {
        int gold, silver, bronze, rank = 0, num;

        Item(int num, int gold, int silver, int bronze) {
            this.num = num;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }

        public boolean sameScore(Item item) {
            return this.gold == item.gold && this.silver == item.silver && this.bronze == item.bronze;
        }
    }

    static void sol() throws IOException {
        Arrays.sort(items, (it1, it2) -> {
            if (it2.gold == it1.gold) {
                if (it2.silver == it1.silver) {
                    return it2.bronze - it1.bronze;
                }
                return it2.silver - it1.silver;
            }
            return it2.gold - it1.gold;
        });

        Item prev = items[0];
        prev.rank = 1;
        for (int i = 1; i < items.length; i++) {
            if (prev.sameScore(items[i])) {
                items[i].rank = prev.rank;
                continue;
            }
            items[i].rank = i + 1;
            prev = items[i];
        }

        for (Item item : items) {
            if (item.num == k) {
                bw.write(item.rank + "");
                return;
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        items = new Item[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            items[i] = new Item(Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()));
        }
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}