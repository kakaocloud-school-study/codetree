package jhyun.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 길이가 같은 경우 : 문자열이 둘 다 같거나, 하나만 바뀐 경우 result++
 * 길이가 +1인 경우 : 단어가 하나 추가된 것으로 cnt가 첫 번째 문자열 길이와 같으면 result++
 * 길이가 -1인 경우 : 단어가 하나 제거된 것으로 비교 문자열의 길이 -1과 cnt가 같으면 result++
 */
public class BOJ2607{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String first = br.readLine();
        int result = 0;

        for (int i = 0; i < n - 1; i++) {
            String str = br.readLine();
            int cnt = 0;
            int[] word = new int[26];
            for (int j = 0; j < first.length(); j++) {
                word[first.charAt(j) - 'A']++;
            }

            for (int j = 0; j < str.length(); j++) {
                if (word[str.charAt(j) - 'A'] > 0) {
                    cnt++;
                    word[str.charAt(j) - 'A']--;
                }
            }

            if (first.length() == str.length() && (first.length() == cnt || first.length() - 1 == cnt)) {
                result++;
            } else if (first.length() == str.length() - 1 && str.length() - 1 == cnt) {
                result++;
            } else if (first.length() == str.length() + 1 && str.length() == cnt) {
                result++;
            }
        }
        System.out.println(result);
    }
}