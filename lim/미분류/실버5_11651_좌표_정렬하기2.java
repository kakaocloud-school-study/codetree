package lim.미분류;

import java.util.*;
import java.io.*;

public class 실버5_11651_좌표_정렬하기2 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static Item[] items;

    static class Item implements Comparable<Item> {
        int x, y;

        public Item(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Item o) {
            if (this.y == o.y) {
                return this.x - o.x;
            }
            return this.y - o.y;
        }
    }

    static void sol() throws IOException {
        Arrays.sort(items);
        for (Item item : items) {
            bw.write(item.x + " " + item.y + "\n");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
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
