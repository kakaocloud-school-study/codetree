package lim.미분류;

import java.util.*;
import java.io.*;

public class 실버5_1676_팩토리얼_0의_개수 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;

    static int factorCount(int factor, int num) {
        if (factor > num) {
            return 0;
        }
        if (num % factor != 0) {
            return 0;
        }
        return factorCount(factor, num / factor) + 1;
    }

    static void sol() throws IOException {
        int twoCount = 0;
        int fiveCount = 0;
        for (int num = 1; num <= n; num++) {
            twoCount += factorCount(2, num);
            fiveCount += factorCount(5, num);
        }
        bw.write(Math.min(twoCount, fiveCount) + "");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}