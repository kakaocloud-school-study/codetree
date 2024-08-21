/*
 * 해설과 다른 풀이 (해설은 이진탐색 사용)
 * f함수 생성 원리를 응용함
 * 1. 패턴을 뒤집은 문자열을 원패턴 뒤에 이어붙인 회문을 만든다 (abcd + dcba)
 * 2. 회문 중심 이후부터 순회하며 f함수를 생성한다
 * 3. f함수 생성 과정에서 비교하는 두 포지션은 원패턴에서의 j + 1위치와 역패턴에서의 위치인 len + i 위치(len은 원패턴 길이)
 */
package lim.문자열;

// import java.util.*;
import java.io.*;

public class KMP_가장_긴_접두사 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static String pattern;

    static void sol() throws IOException {
        int len = pattern.length() / 2;
        int[] f = new int[len + 1];
        f[0] = -1;
        for (int i = 1; i < f.length; i++) {
            int j = f[i - 1];
            while (j >= 0 && pattern.charAt(j + 1) != pattern.charAt(len + i)) {
                j = f[j];
            }
            f[i] = j + 1;
        }

        int answer = 0;
        for (int i = 0; i < f.length; i++) {
            answer = Math.max(answer, f[i]);
        }

        bw.write(answer + "");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine() + '#';
        String reversedLine = new StringBuilder(line).reverse().toString();
        pattern = '#' + line + reversedLine;

        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}
