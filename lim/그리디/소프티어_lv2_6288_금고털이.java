package lim.그리디;

import java.io.*;
import java.util.*;

public class 소프티어_lv2_6288_금고털이 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int limit;
    static Item[] items;

    static class Item implements Comparable<Item> {
        int weight, pricePerWeight;

        public Item(int weight, int pricePerWeight) {
            this.weight = weight;
            this.pricePerWeight = pricePerWeight;
        }

        @Override
        public int compareTo(Item o) {
            return -(this.pricePerWeight - o.pricePerWeight);
        }
    }

    static void sol() throws IOException {
        Arrays.sort(items);
        int totalPrice = 0;
        for (Item item : items) {
            if (limit == 0) {
                break;
            }
            int weightAdd = Math.min(limit, item.weight);
            limit -= weightAdd;
            totalPrice += weightAdd * item.pricePerWeight;
        }
        bw.write(totalPrice + "");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        limit = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        items = new Item[n];
        for (int i = 0; i < items.length; i++) {
            st = new StringTokenizer(br.readLine());
            items[i] = new Item(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        sol();

        br.close();
        bw.flush();
        bw.close();
    }
}
