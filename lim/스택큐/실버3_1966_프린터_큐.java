package lim.스택큐;

import java.util.*;
import java.io.*;

public class 실버3_1966_프린터_큐 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int target;
    static int[] priorities;

    static class Item implements Comparable<Item> {
        int idx, priority;

        public Item(int idx, int priority) {
            this.idx = idx;
            this.priority = priority;
        }

        @Override
        public int compareTo(Item o) {
            return this.priority - o.priority;
        }
    }

    static boolean isMaxIn(LinkedList<Item> queue, int value) {
        return Collections.max(queue).priority == value;
    }

    static void sol() throws IOException {
        LinkedList<Item> queue = new LinkedList<>();
        int idx = 0;
        for (int priority : priorities) {
            queue.offer(new Item(idx++, priority));
        }

        int printOrder = 0;
        while (!queue.isEmpty()) {
            Item item = queue.peek();
            if (isMaxIn(queue, item.priority)) {
                queue.poll();
                printOrder++;
                if (item.idx == target) {
                    bw.write(printOrder + "\n");
                    return;
                }
            } else {
                queue.offer(queue.poll());
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            target = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            priorities = new int[n];
            for (int i = 0; i < priorities.length; i++) {
                priorities[i] = Integer.parseInt(st.nextToken());
            }
            sol();
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
