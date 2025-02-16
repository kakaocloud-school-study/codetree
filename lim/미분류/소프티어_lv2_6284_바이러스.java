package lim.미분류;

import java.io.*;
import java.util.*;

public class 소프티어_lv2_6284_바이러스 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int origin, rate, totalTime;

    static void sol() throws IOException {
        final int MOD = 1000000007;
        long value = origin;
        while (totalTime-- > 0) {
            value *= rate;
            value %= MOD;
        }
        bw.write(value + "");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        origin = Integer.parseInt(st.nextToken());
        rate = Integer.parseInt(st.nextToken());
        totalTime = Integer.parseInt(st.nextToken());

        sol();

        br.close();
        bw.flush();
        bw.close();
    }
}
