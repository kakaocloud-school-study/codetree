package lim.set;

import java.util.*;
import java.io.*;

public class TreeSet_최대로_연속한_숫자 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m;
    static int[] queries;

    static class Span {
        int s, e, len;

        Span(int s, int e) {
            this.s = s;
            this.e = e;
            this.len = e - s - 1;
        }
    }

    static void sol() throws IOException {
        TreeSet<Integer> breakPoints = new TreeSet<>();
        TreeSet<Span> spans = new TreeSet<>((s1, s2) -> {
            if (s1.len == s2.len) {
                if (s1.s == s2.s) {
                    return s1.e - s2.e;
                }
                return s1.s - s2.s;
            }
            return s1.len - s2.len;
        });
        breakPoints.add(-1);
        breakPoints.add(n + 1);
        spans.add(new Span(-1, n + 1));

        for (int i = 0; i < queries.length; i++) {
            int query = queries[i];
            int left = breakPoints.lower(query);
            int right = breakPoints.higher(query);
            spans.remove(new Span(left, right));
            spans.add(new Span(left, query));
            spans.add(new Span(query, right));
            bw.write(spans.last().len + "\n");

            breakPoints.add(query);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        queries = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            queries[i] = Integer.parseInt(st.nextToken());
        }
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}