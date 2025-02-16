package lim.문자열;

import java.io.*;
import java.util.*;

public class 소프티어_lv2_7703_X_marks_the_Spot {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static String[][] queries;

    static void sol() throws IOException {
        for (String[] query : queries) {
            int idx = query[0].indexOf('X');
            bw.write(query[1].charAt(idx));
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        queries = new String[n][2];

        for (int i = 0; i < queries.length; i++) {
            st = new StringTokenizer(br.readLine());
            queries[i][0] = st.nextToken().toUpperCase();
            queries[i][1] = st.nextToken().toUpperCase();
        }

        sol();

        br.close();
        bw.flush();
        bw.close();
    }
}
