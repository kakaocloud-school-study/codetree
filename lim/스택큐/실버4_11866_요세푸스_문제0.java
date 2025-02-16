package lim.스택큐;

import java.util.*;
import java.io.*;

public class 실버4_11866_요세푸스_문제0 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, k;

    static void rotate(int count, LinkedList<Integer> queue) {
        while (count-- > 0) {
            queue.offer(queue.poll());
        }
    }

    static void sol() throws IOException {
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }

        ArrayList<String> arr = new ArrayList<>();
        while (!queue.isEmpty()) {
            rotate(k, queue);
            arr.add(queue.pollLast() + "");
        }
        bw.write("<" + String.join(", ", arr) + ">");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        sol();

        br.close();
        bw.flush();
        bw.close();
    }
}
