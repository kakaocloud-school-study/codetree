package lim.문자열;

// import java.util.*;
import java.io.*;

public class String_Hashing_부분_문자열의_위치_구하기 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static String pattern, word;
    static int P_NUM = 31, M_NUM = 1_000_000_007;

    static void sol() throws IOException {
        long[] pPow = new long[word.length()];
        pPow[0] = 1;
        for (int i = 1; i < pPow.length; i++) {
            pPow[i] = (pPow[i - 1] * P_NUM) % M_NUM;
        }

        long pHash = 0;
        for (int i = 0; i < pattern.length(); i++) {
            long ch = pattern.charAt(i) - 'a' + 1;
            pHash += ch * pPow[pattern.length() - i - 1];
            pHash %= M_NUM;
        }

        long wHash = 0;
        int eIdx = 0;
        int answer = -1;
        for (int i = 0; i + pattern.length() <= word.length(); i++) {
            while (eIdx - i < pattern.length()) {
                long ch = word.charAt(eIdx) - 'a' + 1;
                wHash += (ch * pPow[pattern.length() - (eIdx - i) - 1]) % M_NUM;
                wHash %= M_NUM;
                eIdx++;
            }
            if (pHash == wHash) {
                answer = i;
                break;
            }
            wHash -= ((word.charAt(i) - 'a' + 1) * pPow[pattern.length() - 1]) % M_NUM;
            if (wHash < 0) {
                wHash += M_NUM;
            }
            wHash *= P_NUM;
            wHash %= M_NUM;
        }

        bw.write(answer + "");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        word = br.readLine();
        pattern = br.readLine();
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}
