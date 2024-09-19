package lim.미분류;

import java.util.*;
import java.io.*;

public class 최소_힙_실버2_1927 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int[] arr;

    static void sol() throws IOException {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num : arr) {
            if (num == 0) {
                if (queue.isEmpty()) {
                    bw.write("0\n");
                } else {
                    bw.write(queue.poll() + "\n");
                }
            } else {
                queue.offer(num);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}
