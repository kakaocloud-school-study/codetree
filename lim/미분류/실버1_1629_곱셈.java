/*
 * 분할 정복을 이용한 거듭제곱 연산 시간단축 하는 logN 솔루션
 */
package lim.미분류;

import java.util.*;
import java.io.*;

public class 실버1_1629_곱셈 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int a, b, c;

    static long func(int num, int repeat, int mod) {
        if (repeat == 1) {
            return num % mod;
        }
        long result = 1;
        long halfRepeatResult = func(num, repeat / 2, mod);
        if (repeat % 2 == 0) {
            result *= (halfRepeatResult * halfRepeatResult) % c;
        } else {
            result *= (((halfRepeatResult * halfRepeatResult) % c) * num) % c;
        }
        return result;
    }

    static void sol() throws IOException {
        bw.write(func(a, b, c) + "");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}