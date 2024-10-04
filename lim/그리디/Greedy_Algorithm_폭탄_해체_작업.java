package lim.그리디;

import java.util.*;
import java.io.*;

public class Greedy_Algorithm_폭탄_해체_작업 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static Item[] bombs;

    static class Item implements Comparable<Item> {
        int value, timeout;

        public Item(int value, int timeout) {
            this.value = value;
            this.timeout = timeout;
        }

        @Override
        public int compareTo(Item item) {
            if (item.value == this.value) {
                return item.timeout - this.timeout;
            }
            return item.value - this.value;
        }
    }

    static void sol() throws IOException {
        Arrays.sort(bombs);
        int answer = 0;
        TreeSet<Integer> times = new TreeSet<>();
        for (int num = 0; num < 10_001; num++) {
            times.add(num);
        }
        for (Item bomb : bombs) {
            Integer time = times.lower(bomb.timeout);
            if (time == null) {
                continue;
            }
            times.remove(time);
            answer += bomb.value;
        }
        bw.write(answer + "");
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        bombs = new Item[n];
        for (int i = 0; i < bombs.length; i++) {
            st = new StringTokenizer(br.readLine());
            bombs[i] = new Item(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}
