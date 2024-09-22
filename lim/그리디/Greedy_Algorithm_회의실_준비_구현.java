package lim.그리디;

import java.util.*;
import java.io.*;

public class Greedy_Algorithm_회의실_준비_구현 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static Item[] items;

    static class Item implements Comparable<Item> {
        int s, e;

        public Item(int s, int e) {
            this.s = s;
            this.e = e;
        }

        @Override
        public int compareTo(Item item) {
            return this.e < item.e ? -1 : 1;
        }
    }

    static void sol() throws IOException {
        Arrays.sort(items);
        int count = 0;
        int prevE = 0;
        for (Item item : items) {
            if (prevE <= item.s) {
                prevE = item.e;
                count++;
            }
        }
        bw.write(count + "");
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
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
