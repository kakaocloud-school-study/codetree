package lim.이진탐색;

import java.util.*;
import java.io.*;

public class 실버3_19637_IF문_좀_대신_써줘 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static Condition[] conditions;
    static int[] queries;

    static class Condition implements Comparable<Condition> {
        String name;
        int limit;

        Condition(String name, int limit) {
            this.name = name;
            this.limit = limit;
        }

        @Override
        public int compareTo(Condition o) {
            return this.limit - o.limit;
        }
    }

    static int search(int targetValue) {
        int answerIdx = -1;
        int lo = 0, hi = conditions.length - 1;
        while (lo <= hi) {
            int midIdx = (lo + hi) / 2;
            if (targetValue <= conditions[midIdx].limit) {
                hi = midIdx - 1;
                answerIdx = midIdx;
            } else {
                lo = midIdx + 1;
            }
        }
        return answerIdx;
    }

    static void sol() throws IOException {
        Arrays.sort(conditions);

        for (int value : queries) {
            int idx = search(value);
            bw.write(conditions[idx].name + "\n");
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        conditions = new Condition[n];
        queries = new int[m];

        for (int i = 0; i < conditions.length; i++) {
            st = new StringTokenizer(br.readLine());
            conditions[i] = new Condition(st.nextToken(), Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < queries.length; i++) {
            st = new StringTokenizer(br.readLine());
            queries[i] = Integer.parseInt(st.nextToken());
        }

        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}