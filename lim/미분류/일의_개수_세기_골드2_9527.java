/*
 * (1 << (i - 1)) : 오버플로우남
 * (((long) 1) << (i - 1)) : 이렇게 해야 
 */
package lim.미분류;

import java.util.*;
import java.io.*;

public class 일의_개수_세기_골드2_9527 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static long a, b;
    static long[] dp;
    static ArrayList<Integer> aArr, bArr;

    static ArrayList<Integer> toBin(long num) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(0);
        while (num > 0) {
            arr.add((int) (num & 1));
            num >>= 1;
        }
        return arr;
    }

    static void initDp() {
        dp = new long[bArr.size()];
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = 2 * dp[i - 1] + (((long) 1) << (i - 1));
        }
    }

    static long getSumUnder(ArrayList<Integer> arr) {
        long totalSum = 0;
        long preSum = 0;
        for (int i = arr.size() - 1; i > 0; i--) {
            if (arr.get(i) == 1) {
                totalSum += dp[i - 1] + preSum * (((long) 1) << (i - 1));
            }
            preSum += arr.get(i);
        }
        totalSum += preSum;
        return totalSum;
    }

    static long naiveCal(long a, long b) {
        long cur = a;
        long total = 0;
        while (cur <= b) {
            long num = cur;
            while (num > 0) {
                total += num & 1;
                num >>= 1;
            }
            cur++;
        }
        return total;
    }

    static void sol() throws IOException {
        initDp();

        // long answer = naiveCal(a, b);
        // bw.write(answer + "\n");

        long answer = getSumUnder(bArr) - getSumUnder(aArr);
        // long answer = naiveCal(a, b);
        bw.write(answer + "");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Long.parseLong(st.nextToken());
        b = Long.parseLong(st.nextToken());
        aArr = toBin(a - 1);
        bArr = toBin(b);

        sol();

        bw.flush();
        bw.close();
        br.close();
    }
}

// 10**16
// (2**50)
// 0
// 1
// 10
// 11
// 100
// 101
// 110
// 111
// 1000
// 1001
// 1010
// 1011
// 1100

// 22 - 2 + 1

// 1101
// 1110
// 1111

// 1 4 12
// dp[i] = 2*dp[i-1] + 2^(i-1)

// 0010 -> 1
// 1100 -> 12 + (4 + 1*4)
// -> 21

// 1~111~1000

// 77
// 8 9
// 4 1
// 0 1