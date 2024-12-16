package lim.map;

import java.util.*;
import java.io.*;

public class 실버3_9375_패션왕_신해빈 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static String[][] pairs;

    static void sol() throws IOException {
        HashMap<String, Integer> counts = new HashMap<>();
        for (int i = 0; i < pairs.length; i++) {
            counts.put(pairs[i][1], counts.getOrDefault(pairs[i][1], 0) + 1);
        }

        int answer = 1;
        for (int count : counts.values()) {
            answer *= (count + 1);
        }
        bw.write(answer - 1 + "\n");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        for (int unused = 0; unused < t; unused++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            pairs = new String[n][2];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                pairs[i] = new String[] { st.nextToken(), st.nextToken() };
            }
            sol();
        }
        br.close();
        bw.flush();
        bw.close();
    }
}