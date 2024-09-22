package lim.이진탐색;

/*
 * 정답 숫자 num을 가정한다
 * num보다 작은 숫자들 개수를 구한다
 * "보다 작은 숫자 개수 + 1 <= 주어진 순서"인 최대 num을 구하면 정답
 */
import java.util.*;
import java.io.*;

public class Parametric_Search_이차원_배열의_오름차순_정리 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, targetOrder;

    static long getUnderCount(int rIdx, long num) {
        int left = 0, right = n - 1;
        int idx = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (((long) mid + 1) * (rIdx + 1) < num) {
                left = mid + 1;
                idx = mid;
            } else {
                right = mid - 1;
            }
        }
        return idx + 1;
    }

    static long getUnderCount(long num) {
        long count = 0;
        for (int i = 0; i < n; i++) {
            count += getUnderCount(i, num);
        }
        return count;
    }

    static boolean check(long num) {
        long count = getUnderCount(num);
        return count + 1 <= targetOrder;
    }

    static void sol() throws IOException {
        long left = 1, right = 10_000_000_000L;
        long answer = 0;
        while (left <= right) {
            long mid = (left + right) / 2;
            if (check(mid)) {
                left = mid + 1;
                answer = mid;
            } else {
                right = mid - 1;
            }
        }
        bw.write(answer + "");
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        targetOrder = Integer.parseInt(st.nextToken());
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}
