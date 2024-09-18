package lim.전처리;

import java.util.*;
import java.io.*;

public class 전처리_괄호_쌍_만들어주기 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static String word;

    static void sol() throws IOException {
        int openCount = 0;
        long answer = 0;
        for (int i = 1; i < word.length(); i++) {
            if (word.charAt(i) == '(' && word.charAt(i - 1) == '(') {
                openCount++;
            } else if (word.charAt(i) == ')' && word.charAt(i - 1) == ')') {
                answer += openCount;
            }
        }
        bw.write(answer + "");
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        word = st.nextToken();
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}
