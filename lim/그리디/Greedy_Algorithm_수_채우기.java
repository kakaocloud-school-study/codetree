package lim.그리디;

import java.util.*;
import java.io.*;

public class Greedy_Algorithm_수_채우기 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;

    static void sol() throws IOException {
        int answer = 0;
        while (n % 5 > 0) {
            n -= 2;
            answer++;
        }
        if (n < 0) {
            bw.write("-1");
            return;
        }
        answer += n / 5;
        bw.write(answer + "");
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}
