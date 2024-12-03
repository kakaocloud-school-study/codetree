package lim.스택큐;

import java.util.*;
import java.io.*;

public class 골드5_2493_탑 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] arr;

    static void sol() throws IOException {
        int[] answer = new int[arr.length];
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.getLast()] < arr[i]) {
                stack.pollLast();
            }
            if (!stack.isEmpty()) {
                answer[i] = stack.getLast() + 1;
            }
            stack.offerLast(i);
        }
        for (int num : answer) {
            bw.write(num + " ");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
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
