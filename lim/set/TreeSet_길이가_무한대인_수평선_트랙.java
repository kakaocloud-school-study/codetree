/*
 * 해설보다 좀더 빠른 풀이로 품
 * 그리디 + 스택
 */
package lim.set;

import java.util.*;
import java.io.*;

public class TreeSet_길이가_무한대인_수평선_트랙 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, t;
    static Item[] items;

    static class Item {
        long s, e, speed;

        Item(long s, long speed) {
            this.s = s;
            this.speed = speed;
            this.e = s + speed * t;
        }
    }

    static void sol() throws IOException {
        LinkedList<Item> stack = new LinkedList<>();

        for (Item item : items) {
            while (!stack.isEmpty() && stack.getLast().e >= item.e) {
                stack.pollLast();
            }
            stack.offer(item);
        }
        bw.write(stack.size() + "");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        items = new Item[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            items[i] = new Item(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}