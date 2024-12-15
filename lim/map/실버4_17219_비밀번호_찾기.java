package lim.map;

import java.util.*;
import java.io.*;

public class 실버4_17219_비밀번호_찾기 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static String[][] pairs;
    static String[] queries;

    static void sol() throws IOException {
        HashMap<String, String> pwByUrl = new HashMap<>();
        for (int i = 0; i < pairs.length; i++) {
            pwByUrl.put(pairs[i][0], pairs[i][1]);
        }
        for (String query : queries) {
            bw.write(pwByUrl.get(query) + "\n");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        pairs = new String[n][2];
        queries = new String[m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            pairs[i] = new String[] { st.nextToken(), st.nextToken() };
        }
        for (int i = 0; i < m; i++) {
            queries[i] = br.readLine();
        }

        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}