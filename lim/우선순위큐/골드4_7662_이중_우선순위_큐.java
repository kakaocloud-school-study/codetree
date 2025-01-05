package lim.우선순위큐;

import java.util.*;
import java.io.*;

public class 골드4_7662_이중_우선순위_큐 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;

    static class MinMaxQueue {
        private PriorityQueue<Integer> minQueue = new PriorityQueue<>();
        private PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());
        private HashMap<Integer, Integer> countByNum = new HashMap<>();

        void offer(int num) {
            minQueue.offer(num);
            maxQueue.offer(num);
            countByNum.put(num, countByNum.getOrDefault(num, 0) + 1);
        }

        boolean isEmpty() {
            return minQueue.isEmpty() || maxQueue.isEmpty();
        }

        int peekMin() {
            if (minQueue.isEmpty()) {
                return Integer.MAX_VALUE;
            }
            int num = minQueue.peek();
            while (countByNum.getOrDefault(num, 0) == 0) {
                minQueue.poll();
                if (minQueue.isEmpty()) {
                    return Integer.MAX_VALUE;
                }
                num = minQueue.peek();
            }
            return num;
        }

        int peekMax() {
            if (maxQueue.isEmpty()) {
                return Integer.MIN_VALUE;
            }
            int num = maxQueue.peek();
            while (countByNum.getOrDefault(num, 0) == 0) {
                maxQueue.poll();
                if (maxQueue.isEmpty()) {
                    return Integer.MIN_VALUE;
                }
                num = maxQueue.peek();
            }
            return num;
        }

        void deleteMin() {
            peekMin();
            peekMax();
            if (minQueue.isEmpty()) {
                return;
            }
            int num = minQueue.poll();
            int count = countByNum.get(num);
            if (count == 1) {
                countByNum.remove(num);
                return;
            }
            countByNum.put(num, count - 1);
        }

        void deleteMax() {
            peekMin();
            peekMax();
            if (maxQueue.isEmpty()) {
                return;
            }
            int num = maxQueue.poll();
            int count = countByNum.get(num);
            if (count == 1) {
                countByNum.remove(num);
                return;
            }
            countByNum.put(num, count - 1);
        }
    }

    static void sol() throws IOException {
        MinMaxQueue queue = new MinMaxQueue();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            int value = Integer.parseInt(st.nextToken());

            if (cmd.equals("I")) {
                queue.offer(value);
            } else if (cmd.equals("D") && value == -1) {
                queue.deleteMin();
            } else if (cmd.equals("D") && value == 1) {
                queue.deleteMax();
            }
        }

        int minNum = queue.peekMin();
        int maxNum = queue.peekMax();
        if (queue.isEmpty()) {
            bw.write("EMPTY\n");
            return;
        }
        bw.write(maxNum + " " + minNum + "\n");
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            sol();
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
