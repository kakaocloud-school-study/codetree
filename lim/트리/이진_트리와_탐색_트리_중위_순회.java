package lim.트리;

import java.util.*;
import java.io.*;

public class 이진_트리와_탐색_트리_중위_순회 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] arr;
    static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();

    static void func(int s, int e, int depth) {
        while (tree.size() <= depth) {
            tree.add(new ArrayList<>());
        }
        if (s == e) {
            tree.get(depth).add(arr[e]);
            return;
        }
        int mid = (s + e) / 2;
        tree.get(depth).add(arr[mid]);
        func(s, mid - 1, depth + 1);
        func(mid + 1, e, depth + 1);
    }

    static void sol() throws IOException {
        func(0, arr.length - 1, 0);
        for (int i = 0; i < tree.size(); i++) {
            for (int j = 0; j < tree.get(i).size(); j++) {
                bw.write(tree.get(i).get(j) + " ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        arr = new int[(int) (Math.pow(2, k) - 1)];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        sol();
        br.close();
    }
}
