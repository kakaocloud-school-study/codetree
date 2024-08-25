package lim.비트마스크;

import java.util.*;
import java.io.*;

public class Bitmask_bit_계산 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int mask;
    static String[][] queries;

    static void sol() throws IOException {
        for (String[] q : queries) {
            String op = q[0];
            int intValue = 0;
            if (q.length > 1) {
                intValue = Integer.parseInt(q[1]);
            }

            if (op.equals("add")) {
                mask |= 1 << intValue;
            } else if (op.equals("delete")) {
                mask -= mask & (1 << intValue);
            } else if (op.equals("print")) {
                bw.write((mask & (1 << intValue)) > 0 ? "1\n" : "0\n");
            } else if (op.equals("toggle")) {
                mask ^= 1 << intValue;
            } else if (op.equals("clear")) {
                mask = 0;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        queries = new String[n][2];
        for (int i = 0; i < n; i++) {
            queries[i] = br.readLine().split(" ");
        }
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}
