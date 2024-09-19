package lim.미분류;

import java.util.*;
import java.io.*;

public class 탑_보기_골드3_22866 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int[] arr;

    static void sol() throws IOException {
        LinkedList<Integer> stack = new LinkedList<>();
        int[] neighbors = new int[n];
        int[] counts = new int[n];
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.getLast()] <= arr[i]) {
                stack.pollLast();
            }
            if (!stack.isEmpty()) {
                neighbors[i] = stack.getLast() + 1;
                counts[i] += stack.size();
            }
            stack.offerLast(i);
        }
        stack.clear();
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.getLast()] <= arr[i]) {
                stack.pollLast();
            }
            if (!stack.isEmpty()) {
                if (neighbors[i] == 0) {
                    neighbors[i] = stack.getLast() + 1;
                } else if (stack.getLast() - i < i - (neighbors[i] - 1)) {
                    neighbors[i] = stack.getLast() + 1;
                } else if (stack.getLast() - i == i - (neighbors[i] - 1)) {
                    neighbors[i] = Math.min(neighbors[i], stack.getLast() + 1);
                }
                counts[i] += stack.size();
            }
            stack.offerLast(i);
        }

        for (int i = 0; i < counts.length; i++) {
            if (counts[i] == 0) {
                bw.write("0\n");
                continue;
            }
            bw.write(counts[i] + " " + neighbors[i] + "\n");
        }
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
