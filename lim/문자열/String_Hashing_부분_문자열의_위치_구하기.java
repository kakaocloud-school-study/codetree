package lim.문자열;

// import java.util.*;
import java.io.*;

public class String_Hashing_부분_문자열의_위치_구하기 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static String word, subword;
    static int P_NUM = 31, M_NUM = 1_000_000_007;

    static void sol() throws IOException {
        long[] pPow = new long[word.length()];
        pPow[0] = 1;
        for (int i = 1; i < pPow.length; i++) {
            pPow[i] = (pPow[i - 1] * P_NUM) % M_NUM;
        }

        long hashedSubWord = 0;
        for (int i = 0; i < subword.length(); i++) {
            long ch = subword.charAt(i) - 'a' + 1;
            hashedSubWord += ch * pPow[i];
            hashedSubWord %= M_NUM;
        }

        long hashedWord = 0;
        int eIdx = 0;
        int answer = -1;
        for (int i = 0; i + subword.length() <= word.length(); i++) {
            while (eIdx - i < subword.length()) {
                long ch = word.charAt(eIdx) - 'a' + 1;
                hashedWord += (ch * pPow[eIdx]) % M_NUM;
                hashedWord %= M_NUM;
                eIdx++;
            }
            if (hashedWord == hashedSubWord) {
                answer = i;
                break;
            }
            hashedWord -= (((long) (word.charAt(i) - 'a' + 1)) * pPow[i]);
            if (hashedWord < 0) {
                hashedWord += M_NUM;
            }
            hashedWord %= M_NUM;

            hashedSubWord *= P_NUM;
            hashedSubWord %= M_NUM;
        }

        bw.write(answer + "");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        word = br.readLine();
        subword = br.readLine();
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}
