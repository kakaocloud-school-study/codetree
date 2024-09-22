package lim.그리디;

import java.util.*;
import java.io.*;

public class Greedy_Algorithm_최대_숫자_만들기 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static String[] words;

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
        Arrays.sort(words, (w1, w2) -> Long.parseLong(w1 + w2) < Long.parseLong(w2 + w1) ? 1 : -1);
        bw.write(String.join("", words));
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        words = new String[n];
        for (int i = 0; i < words.length; i++) {
            words[i] = br.readLine();
        }
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}
