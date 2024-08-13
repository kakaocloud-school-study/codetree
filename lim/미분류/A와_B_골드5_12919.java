/*
 * 깊이가 50이며 두 연산으로 분기되는 재귀이므로 가지치기가 필요
 * 타켓 문자열에서 빼가는 순서대로 하고 가능한 연산만 가지치기하면 됨
 * substring end index가 비포함에 주의
 * 
 */
package lim.미분류;

import java.io.*;

public class A와_B_골드5_12919 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static String sStr, tStr;
    static int answer = 0;

    static void func(String word) {
        if (word.length() == sStr.length()) {
            if (word.equals(sStr)) {
                answer = 1;
            }
            return;
        }
        if (word.charAt(0) == 'B') {
            StringBuilder sb = new StringBuilder(word);
            sb = sb.reverse();
            String newWord = sb.substring(0, word.length() - 1);
            func(newWord);
        }
        if (word.charAt(word.length() - 1) == 'A') {
            func(word.substring(0, word.length() - 1));
        }
    }

    static void sol() throws IOException {
        func(tStr);
        bw.write(answer + "");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        sStr = br.readLine();
        tStr = br.readLine();

        sol();

        bw.flush();
        bw.close();
        br.close();
    }
}