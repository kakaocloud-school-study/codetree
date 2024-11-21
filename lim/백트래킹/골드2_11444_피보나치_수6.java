/*
 * 기존 점화식을 변형해서 n을 절반 정도로 줄이는 특수한 점화식으로 바꿔야함
 * 그 이후는 분할정복 거듭제곱 문제랑 비슷하게 풀이됨
 */
package lim.백트래킹;

import java.util.*;
import java.io.*;

public class 골드2_11444_피보나치_수6 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static long n;
    static final int MOD = 1_000_000_007;
    static HashMap<Long, Long> mem = new HashMap<>();

    static long fibAt(long num) {
        if (num == 0) {
            return 0;
        }
        if (num == 1 || num == 2) {
            return 1;
        }
        if (mem.containsKey(num)) {
            return mem.get(num);
        }

        if (num % 2 == 0) {
            long valN = fibAt(num / 2);
            long valNM1 = fibAt(num / 2 - 1);
            mem.put(num, (((((2 * valNM1) % MOD) + valN) % MOD) * valN) % MOD);
        } else {
            long valN = fibAt(num / 2 + 1);
            long valNM1 = fibAt(num / 2);
            mem.put(num, (((valN * valN) % MOD) + ((valNM1 * valNM1) % MOD)) % MOD);
        }
        return mem.get(num);
    }

    static void sol() throws IOException {
        bw.write(fibAt(n) + "");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Long.parseLong(st.nextToken());
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}
