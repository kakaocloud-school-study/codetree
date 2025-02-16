package lim.문자열;

import java.io.*;
import java.util.*;

public class 실버5_10814_나이순_정렬 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static ArrayList<Item> items = new ArrayList<>();

    static class Item implements Comparable<Item> {
        int age, order;
        String name;

        public Item(int age, int order, String name) {
            this.age = age;
            this.order = order;
            this.name = name;
        }

        @Override
        public int compareTo(Item o) {
            if (this.age == o.age) {
                return this.order - o.order;
            }
            return this.age - o.age;
        }
    }

    static void sol() throws IOException {
        Collections.sort(items);
        for (int i = 0; i < items.size(); i++) {
            bw.write(items.get(i).age + " " + items.get(i).name + "\n");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            items.add(new Item(Integer.parseInt(st.nextToken()), i, st.nextToken()));
        }
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}