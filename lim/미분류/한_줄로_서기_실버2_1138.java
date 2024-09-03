/*
 * 키큰 순으로 나열 후 하나씩 뽑아 줄을 세워감
 * 먼저 선 사람들은 그 뒤 서는 사람보다 무조건 크므로 후속주자가 어디서든 내앞수에 영향이 없음
 * 줄 세울 사람의 내앞수를 이미 선 line의 idx로 하여 삽입하면 됨
 */
package lim.미분류;

import java.util.*;
import java.io.*;

public class 한_줄로_서기_실버2_1138 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static Item[] items;

    static class Item {
        int height, frontTallerCount;

        Item(int height, int frontTallerCount) {
            this.height = height;
            this.frontTallerCount = frontTallerCount;
        }
    }

    static void sol() throws IOException {
        Arrays.sort(items, (it1, it2) -> it2.height - it1.height);

        ArrayList<Item> line = new ArrayList<>();
        for (Item item : items) {
            // line에는 이미 나보다 큰 사람들이 서있다.
            line.add(item.frontTallerCount, item);
        }
        for (Item item : line) {
            bw.write(item.height + " ");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        items = new Item[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            items[i] = new Item(i + 1, Integer.parseInt(st.nextToken()));
        }
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}