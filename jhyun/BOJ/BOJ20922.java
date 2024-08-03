package jhyun.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ20922 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0, start = 0, end = 0;
        int[] cnt = new int[100_101];
        while (end < arr.length) {
            while (end < arr.length && cnt[arr[end]] + 1 <= k) { //end는 배열 크기보다 작으면서, end가 나타내는 인덱스의 원소값의 갯수가 k개 이하인 경우
                cnt[arr[end]]++;
                end++; //최장 길이 갱신
            }
            int len = end - start;
            ans = Math.max(ans, len);
            cnt[arr[start]]--;
            start++;
        }
        System.out.println(ans);
    }
}