/*
 * dp[자리수][소비성냥개수][최대최소여부][앞자리0여부]
 * 최대 50자리수까지 가능하기에 long으로도 커버가 안되므로 String으로 다뤄야함
 */
package lim.미분류;

import java.util.*;
import java.io.*;

public class 성냥개비_골드2_3687 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static String[][][][] dp;
    static int[] matchesByNum = { 6, 2, 5, 5, 4, 5, 6, 3, 7, 6 }, queries;
    static final int MAX_SUM = 100, MAX_POS = 50, MAX_VALUE = 0, MIN_VALUE = 1, START_WITH_ZERO = 0,
            START_WITH_NONZERO = 1;

    static int compare(String num1, String num2) {
        if (num1.length() != num2.length()) {
            return num1.length() - num2.length();
        }
        int len = num1.length();
        for (int i = 0; i < len; i++) {
            if (num1.charAt(i) != num2.charAt(i)) {
                return num1.charAt(i) - num2.charAt(i);
            }
        }
        return 0;
    }

    static String min(String num1, String num2) {
        if (num1 == null) {
            return num2;
        }
        if (num2 == null) {
            return num1;
        }
        return compare(num1, num2) <= 0 ? num1 : num2;
    }

    static String max(String num1, String num2) {
        if (num1 == null) {
            return num2;
        }
        if (num2 == null) {
            return num1;
        }
        return compare(num1, num2) <= 0 ? num2 : num1;
    }

    static void sol() throws IOException {
        for (int num = 0; num < matchesByNum.length; num++) {
            if (num == 0) {
                dp[1][matchesByNum[num]][MIN_VALUE][START_WITH_ZERO] = min(
                        dp[1][matchesByNum[num]][MIN_VALUE][START_WITH_ZERO], String.valueOf(num));
                dp[1][matchesByNum[num]][MAX_VALUE][START_WITH_ZERO] = max(
                        dp[1][matchesByNum[num]][MAX_VALUE][START_WITH_ZERO], String.valueOf(num));
                continue;
            }
            dp[1][matchesByNum[num]][MIN_VALUE][START_WITH_NONZERO] = min(
                    dp[1][matchesByNum[num]][MIN_VALUE][START_WITH_NONZERO], String.valueOf(num));
            dp[1][matchesByNum[num]][MAX_VALUE][START_WITH_NONZERO] = max(
                    dp[1][matchesByNum[num]][MAX_VALUE][START_WITH_NONZERO], String.valueOf(num));
        }

        for (int pos = 1; pos < MAX_POS; pos++) {
            for (int matchesSum = 0; matchesSum < MAX_SUM + 1; matchesSum++) {
                for (int num = 0; num < matchesByNum.length; num++) {
                    int nextSum = matchesSum + matchesByNum[num];
                    if (nextSum > MAX_SUM) {
                        continue;
                    }

                    int startWith = num == 0 ? START_WITH_ZERO : START_WITH_NONZERO;
                    if (dp[pos][matchesSum][MIN_VALUE][START_WITH_ZERO] != null) {
                        dp[pos + 1][nextSum][MIN_VALUE][startWith] = min(
                                dp[pos + 1][nextSum][MIN_VALUE][startWith],
                                num + dp[pos][matchesSum][MIN_VALUE][START_WITH_ZERO]);
                    }
                    if (dp[pos][matchesSum][MIN_VALUE][START_WITH_NONZERO] != null) {
                        dp[pos + 1][nextSum][MIN_VALUE][startWith] = min(
                                dp[pos + 1][nextSum][MIN_VALUE][startWith],
                                num + dp[pos][matchesSum][MIN_VALUE][START_WITH_NONZERO]);
                    }
                    if (dp[pos][matchesSum][MAX_VALUE][START_WITH_ZERO] != null) {
                        dp[pos + 1][nextSum][MAX_VALUE][startWith] = max(
                                dp[pos + 1][nextSum][MAX_VALUE][startWith],
                                num + dp[pos][matchesSum][MAX_VALUE][START_WITH_ZERO]);
                    }
                    if (dp[pos][matchesSum][MAX_VALUE][START_WITH_NONZERO] != null) {
                        dp[pos + 1][nextSum][MAX_VALUE][startWith] = max(
                                dp[pos + 1][nextSum][MAX_VALUE][startWith],
                                num + dp[pos][matchesSum][MAX_VALUE][START_WITH_NONZERO]);
                    }
                }
            }
        }

        for (int matchesSum : queries) {
            String minValue = null;
            String maxValue = null;
            for (int pos = 1; pos < MAX_POS + 1; pos++) {
                if (dp[pos][matchesSum][MIN_VALUE][START_WITH_NONZERO] != null) {
                    minValue = min(minValue, dp[pos][matchesSum][MIN_VALUE][START_WITH_NONZERO]);
                }
                if (dp[pos][matchesSum][MAX_VALUE][START_WITH_NONZERO] != null) {
                    maxValue = max(maxValue, dp[pos][matchesSum][MAX_VALUE][START_WITH_NONZERO]);
                }
            }
            bw.write(minValue + " " + maxValue + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        dp = new String[MAX_POS + 1][MAX_SUM + 1][2][2];
        queries = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            queries[i] = Integer.parseInt(st.nextToken());
        }
        sol();
        br.close();
    }
}
