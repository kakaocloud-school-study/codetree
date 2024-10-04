package lim.그리디;

import java.util.*;
import java.io.*;

public class Greedy_Algorithm_적석과_흑석2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, c;
    static int[] arr;
    static Item[] segments;

    static class Item implements Comparable<Item> {
        int s, e;

        public Item(int s, int e) {
            this.s = s;
            this.e = e;
        }

        boolean contains(int num) {
            return s <= num && num <= e;
        }

        @Override
        public int compareTo(Item item) {
            return this.e - item.e < 0 ? -1 : 1;
        }
    }

    static void sol() throws IOException {
        TreeSet<Integer> nums = new TreeSet<>();
        for (int num : arr) {
            nums.add(num);
        }
        Arrays.sort(segments);
        int answer = 0;
        for (Item segment : segments) {
            Integer num = nums.ceiling(segment.s);
            if (num == null || segment.e < num) {
                continue;
            }
            nums.remove(num);
            answer++;
        }
        bw.write(answer + "");
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        c = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        arr = new int[c];
        segments = new Item[n];
        for (int i = 0; i < arr.length; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < segments.length; i++) {
            st = new StringTokenizer(br.readLine());
            segments[i] = new Item(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}
