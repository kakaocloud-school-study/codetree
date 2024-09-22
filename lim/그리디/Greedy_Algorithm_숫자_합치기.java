package lim.그리디;

import java.util.*;
import java.io.*;

public class Greedy_Algorithm_숫자_합치기 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int[] arr;

    static void sol() throws IOException {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num : arr) {
            queue.offer(num);
        }

        int answer = 0;
        while (queue.size() > 1) {
            int num1 = queue.poll();
            int num2 = queue.poll();
            queue.add(num1 + num2);
            answer += num1 + num2;
        }
        bw.write(answer + "");
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}
