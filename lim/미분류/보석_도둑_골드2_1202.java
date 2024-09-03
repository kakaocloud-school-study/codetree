/*
 * 제발 long 좀 주의
 * 
 * 배낭문제는 일차원DP로는 못푼다
 * 그런데 n, k가 각각 300,000이라 2차원 DP 불가
 * 그밖에 변수들도 모두 배열의 차원으로 못쓸정도로 크다
 * DP로도 커버 못하는 문제 -> 그리디
 * 그리디 + 투포인터 + 우선순위큐
 * 가방과 보석을 무게순 정렬
 * 가방을 작은것부터 하나씩 순회. 현재 가방에 들어갈 수 있는 모든 보석을 우선순위큐(가치순)에 삽입
 * 현재 가방에 넣을 가장 고가의 보석을 우선순위큐에서 팝하고 다음 가방으로 넘어감. 없는 경우 바로 다음 가방
 */
package lim.미분류;

import java.util.*;
import java.io.*;

public class 보석_도둑_골드2_1202 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, k;
    static Item[] items;
    static int[] bags;

    static class Item {
        int price, weight;

        Item(int weight, int price) {
            this.price = price;
            this.weight = weight;
        }
    }

    static void sol() throws IOException {
        PriorityQueue<Item> queue = new PriorityQueue<>((it1, it2) -> it2.price - it1.price);
        long totalPrice = 0;
        int itemIdx = 0;
        for (int bagIdx = 0; bagIdx < bags.length; bagIdx++) {
            int weightLimit = bags[bagIdx];
            while (itemIdx < items.length && items[itemIdx].weight <= weightLimit) {
                queue.offer(items[itemIdx]);
                itemIdx++;
            }
            if (!queue.isEmpty()) {
                Item item = queue.poll();
                totalPrice += item.price;
            }
        }
        bw.write(totalPrice + "");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        items = new Item[n];
        bags = new int[k];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            items[i] = new Item(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            bags[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(items, (it1, it2) -> {
            if (it1.weight == it2.weight) {
                return it2.price - it1.price;
            }
            return it1.weight - it2.weight;
        });
        Arrays.sort(bags);
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}
