package lim.좌표압축;

import java.util.*;
import java.io.*;

public class Grid_Compression_점_개수_세기3 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, q;
    static HashMap<Integer, Integer> idxByPos = new HashMap<>();
    static int[] counts, presumArr;
    static int[][] queries;

    static void sol() throws IOException {
        for (int i = 1; i < counts.length; i++) {
            presumArr[i] = counts[i] + presumArr[i - 1];
        }
        for (int i = 0; i < queries.length; i++) {
            int s = queries[i][0], e = queries[i][1];
            int sIdx = idxByPos.get(s), eIdx = idxByPos.get(e);
            int count = presumArr[eIdx] - presumArr[sIdx - 1];
            bw.write(count + "\n");
        }
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        counts = new int[n + 1];
        presumArr = new int[n + 1];
        queries = new int[q][2];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            counts[i] = 1;
            idxByPos.put(Integer.parseInt(st.nextToken()), i);
        }
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            queries[i][0] = Integer.parseInt(st.nextToken());
            queries[i][1] = Integer.parseInt(st.nextToken());
        }
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}
