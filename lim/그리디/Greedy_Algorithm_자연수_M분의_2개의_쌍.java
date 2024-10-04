package lim.그리디;

import java.util.*;
import java.io.*;

public class Greedy_Algorithm_자연수_M분의_2개의_쌍 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static Item[] items;

    static class Item implements Comparable<Item> {
        long value;
        int count;

        public Item(int count, long value) {
            this.count = count;
            this.value = value;
        }

        @Override
        public int compareTo(Item item) {
            return this.value < item.value ? -1 : 1;
        }
    }

    static void sol() throws IOException {
        Arrays.sort(items);
        long answer = 0;
        int sIdx = 0;
        int eIdx = items.length - 1;
        while (sIdx <= eIdx) {
            answer = Math.max(answer, items[sIdx].value + items[eIdx].value);

            if (sIdx == eIdx) {
                break;
            }

            int coupleCount = Math.min(items[sIdx].count, items[eIdx].count);
            items[sIdx].count -= coupleCount;
            items[eIdx].count -= coupleCount;
            if (items[sIdx].count == 0) {
                sIdx++;
            }
            if (items[eIdx].count == 0) {
                eIdx--;
            }
        }
        bw.write(answer + "");
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
