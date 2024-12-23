package lim.우선순위큐;

import java.util.*;
import java.io.*;

public class 실버2_11279_최대_힙 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int[] arr;

    static void sol() throws IOException {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int num : arr) {
           if (num == 0) {
            if (queue.isEmpty()) {
                bw.write("0\n");
                continue;
            }
            bw.write(queue.poll() + "\n");
           } else {
            queue.offer(num);
           }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}
