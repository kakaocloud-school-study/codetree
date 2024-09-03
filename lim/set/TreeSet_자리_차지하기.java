package lim.set;

import java.util.*;
import java.io.*;

public class TreeSet_자리_차지하기 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m;
    static int[] reqs;

    static void sol() throws IOException {
        TreeSet<Integer> chairs = new TreeSet<>();
        for (int i = 1; i < m + 1; i++) {
            chairs.add(i);
        }

        int count = 0;
        for (int i = 0; i < reqs.length; i++) {
            int req = reqs[i];
            Integer chair = chairs.floor(req);
            if (chair == null) {
                break;
            }
            chairs.remove(chair);
            count++;
        }
        bw.write(count + "");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        reqs = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            reqs[i] = Integer.parseInt(st.nextToken());
        }
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}