/*
 * int 한도 때문에 long 사용해야 함
 * dp1: 끝이 |
 * dp2: 끝이 :
 * dp3: 끝이 ㅡ'
 * dp4: 끝이 ㅡ.
 * dp5: 끝이 二
 */
package lim.DP;

import java.util.*;
import java.io.*;

public class subproblem을_그대로_합치면_되는_DP_사각형_채우기3 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static long[] dp1, dp2, dp3, dp4, dp5;

    static int func(int num) {
        for (int i = 3; i < dp1.length; i++) {
            dp1[i] = (dp1[i - 1] + dp2[i - 1] + dp3[i - 1] + dp4[i - 1] + dp5[i - 1]) % 1_000_000_007;
            dp2[i] = (dp1[i - 1] + dp2[i - 1] + dp3[i - 1] + dp4[i - 1] + dp5[i - 1]) % 1_000_000_007;
            dp3[i] = (dp2[i - 1] + dp4[i - 1]) % 1_000_000_007;
            dp4[i] = (dp1[i - 1] + dp3[i - 1]) % 1_000_000_007;
            dp5[i] = (dp1[i - 2] + dp2[i - 2] + dp3[i - 2] + dp4[i - 2] + dp5[i - 2]) % 1_000_000_007;
        }
        // System.out.printf("%d %d %d %d %d\n", dp1[num], dp2[num], dp3[num], dp4[num],
        // dp5[num]);
        return (int) ((dp1[num] + dp2[num] + dp3[num] + dp4[num] + dp5[num]) % 1_000_000_007);
    }

    static void sol(int num) throws IOException {
        dp1[1] = 1;
        dp2[1] = 1;
        dp1[2] = 2;
        dp2[2] = 2;
        dp3[2] = 1;
        dp4[2] = 1;
        dp5[2] = 1;
        int answer = func(num);
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        dp1 = new long[Math.max(4, n + 1)];
        dp2 = new long[Math.max(4, n + 1)];
        dp3 = new long[Math.max(4, n + 1)];
        dp4 = new long[Math.max(4, n + 1)];
        dp5 = new long[Math.max(4, n + 1)];
        sol(n);
        br.close();
    }
}
