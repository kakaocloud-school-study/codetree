package lim.우선순위큐;

import java.util.*;
import java.io.*;

public class Priority_Queue_마지막으로_남은_숫자 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int[] arr;

    static void sol() throws IOException {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int num : arr) {
            queue.offer(num);
        }

        while (queue.size() > 1) {
            int num1 = queue.poll();
            int num2 = queue.poll();
            if (num1 == num2) {
                continue;
            }
            queue.offer(num1 - num2);
        }

        if (queue.isEmpty()) {
            bw.write("-1");
            return;
        }
        bw.write(queue.peek() + "");
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