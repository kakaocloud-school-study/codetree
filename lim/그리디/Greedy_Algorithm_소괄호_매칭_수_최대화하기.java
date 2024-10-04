/*
 * 괄호개수를 미리 계산해서 더 단축 가능
 * -1, 0, 1 방식으로 정규화하려면 -1, 1로 삼항연산자 쓰지말고 3경우 모두 분기문으로
 */
package lim.그리디;

import java.util.*;
import java.io.*;

public class Greedy_Algorithm_소괄호_매칭_수_최대화하기 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static String[] words;

    static long count(String word) {
        long openCount = 0;
        long count = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == '(') {
                openCount++;
            } else {
                count += openCount;
            }
        }
        return count;
    }

    static void sol() throws IOException {
        Arrays.sort(words, (w1, w2) -> {
            long count1 = count(w1 + w2);
            long count2 = count(w2 + w1);
            if (count1 < count2) {
                return 1;
            }
            if (count1 > count2) {
                return -1;
            }
            return 0;
        });
        long answer = count(String.join("", words));
        bw.write(answer + "");
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        words = new String[n];
        for (int i = 0; i < words.length; i++) {
            words[i] = br.readLine();
        }
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}