package lim.트리;

import java.util.*;
import java.io.*;

public class 이진_트리와_탐색_트리_경유 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] tree, queries;

    static int func(int target) throws IOException {
        int obstacle = 0;
        int num = target;
        while (num > 1) {
            if (tree[num] > 0) {
                obstacle = num;
            }
            if (num % 2 == 0) {
                num /= 2;
                continue;
            }
            num = (num - 1) / 2;
        }
        if (tree[1] > 0) {
            obstacle = num;
        }

        if (obstacle == 0) {
            tree[target] = 1;
        }
        return obstacle;
    }

    static void sol() throws IOException {
        for (int i = 0; i < queries.length; i++) {
            int target = queries[i];
            int result = func(target);
            bw.write(result + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        tree = new int[n + 1];
        queries = new int[q];
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            queries[i] = Integer.parseInt(st.nextToken());
        }
        sol();
        br.close();
    }
}
