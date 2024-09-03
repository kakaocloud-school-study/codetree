/*
 * 두 수열을 정렬.
 * 첫 번째 쌍은 (a0, b0)일 것임
 * 그 다음 쌍은 (a1, b0) 또는 (a0, b1)임. 특정 쌍의 다음 쌍은 무조건 인접해 있음.
 * 큐에 다음 방문할 쌍을 넣고 bfs
 * 방문을 가장 작은 쌍부터 하므로 poll할때마다 카운트하면 k번째 구할수있음
 * poll을 최대 100,000번하고
 * offer를 최대 200,000번하므로 시간, 공간 내에 가능
 * 
 * 해설과 비슷하지만 해설보다 직관적인 풀이인듯
 */
package lim.우선순위큐;

import java.util.*;
import java.io.*;

public class Priority_Queue_k번째로_작은_쌍의_합 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m, k;
    static int[] arr1, arr2;

    static class Item implements Comparable<Item> {
        int idx1, idx2, valueSum;

        Item(int idx1, int idx2) {
            this.idx1 = idx1;
            this.idx2 = idx2;
            this.valueSum = arr1[idx1] + arr2[idx2];
        }

        @Override
        public int compareTo(Item item) {
            return this.valueSum - item.valueSum;
        }
    }

    static void sol() throws IOException {
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        PriorityQueue<Item> queue = new PriorityQueue<>();
        HashMap<Integer, HashSet<Integer>> visited = new HashMap<>();
        for (int i = 0; i < arr1.length; i++) {
            visited.put(i, new HashSet<>());
        }

        queue.offer(new Item(0, 0));
        visited.get(0).add(0);

        int count = 0;
        while (!queue.isEmpty()) {
            Item item = queue.poll();
            count++;
            if (count == k) {
                bw.write(item.valueSum + "");
                return;
            }
            if (item.idx1 + 1 < arr1.length && !visited.get(item.idx1 + 1).contains(item.idx2)) {
                queue.offer(new Item(item.idx1 + 1, item.idx2));
                visited.get(item.idx1 + 1).add(item.idx2);
            }
            if (item.idx2 + 1 < arr2.length && !visited.get(item.idx1).contains(item.idx2 + 1)) {
                queue.offer(new Item(item.idx1, item.idx2 + 1));
                visited.get(item.idx1).add(item.idx2 + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr1 = new int[n];
        arr2 = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}