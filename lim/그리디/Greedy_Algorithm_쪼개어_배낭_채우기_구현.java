package lim.그리디;

import java.util.*;
import java.io.*;

public class Greedy_Algorithm_쪼개어_배낭_채우기_구현 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, space;
    static Item[] items;

    static class Item implements Comparable<Item> {
        int w, v;

        public double getUnitV() {
            return ((double) v) / w;
        }

        public Item(int w, int v) {
            this.w = w;
            this.v = v;
        }

        @Override
        public int compareTo(Item item) {
            return this.getUnitV() < item.getUnitV() ? 1 : -1;
        }
    }

    static void sol() throws IOException {
        Arrays.sort(items);
        double totalValue = 0;
        for (Item item : items) {
            int weight = Math.min(space, item.w);
            totalValue += weight * item.getUnitV();
            space -= weight;
            if (space == 0) {
                break;
            }
        }
        bw.write(String.format("%.3f", totalValue));
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        space = Integer.parseInt(st.nextToken());
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
