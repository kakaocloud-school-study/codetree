package lim.우선순위큐;

import java.util.*;
import java.io.*;

public class Priority_Queue_앞에서부터_삭제하기2 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int[] arr;

    static class Item implements Comparable<Item> {
        int num, idx;

        Item(int num, int idx) {
            this.num = num;
            this.idx = idx;
        }

        @Override
        public int compareTo(Item item) {
            return this.num - item.num;
        }
    }

    static void sol() throws IOException {
        PriorityQueue<Item> queue = new PriorityQueue<>();
        int totalSum = 0;
        float maxAvg = 0;

        for (int i = 0; i < arr.length; i++) {
            queue.offer(new Item(arr[i], i));
            totalSum += arr[i];
        }

        for (int i = 0; i < arr.length - 2; i++) {
            totalSum -= arr[i];
            while (queue.peek().idx <= i) {
                queue.poll();
            }
            int minNum = queue.peek().num;
            int count = arr.length - i - 1;
            float avg = ((float) (totalSum - minNum)) / (count - 1);
            maxAvg = Math.max(maxAvg, avg);
        }
        System.out.printf("%.2f", maxAvg);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}