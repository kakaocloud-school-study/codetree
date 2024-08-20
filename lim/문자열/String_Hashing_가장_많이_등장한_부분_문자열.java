package lim.문자열;

import java.util.*;
import java.io.*;

public class String_Hashing_가장_많이_등장한_부분_문자열 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static String word;
    static final int P_NUM = 31, M_NUM = 1_000_000_007;
    static int l;

    static void sol() throws IOException {
        HashMap<Long, Integer> countByHash = new HashMap<>();
        long[] pPow = new long[word.length()];
        pPow[0] = 1;
        for (int i = 1; i < pPow.length; i++) {
            pPow[i] = (pPow[i - 1] * P_NUM) % M_NUM;
        }

        long wHash = 0;
        int eIdx = 0;
        int answer = -1;
        for (int i = 0; i + l <= word.length(); i++) {
            while (eIdx - i < l) {
                long ch = word.charAt(eIdx) - 'a' + 1;
                wHash += (ch * pPow[l - (eIdx - i) - 1]) % M_NUM;
                wHash %= M_NUM;
                eIdx++;
            }

            countByHash.put(wHash, countByHash.getOrDefault(wHash, 0) + 1);

            wHash -= ((word.charAt(i) - 'a' + 1) * pPow[l - 1]) % M_NUM;
            if (wHash < 0) {
                wHash += M_NUM;
            }
            wHash *= P_NUM;
            wHash %= M_NUM;
        }

        for (int count : countByHash.values()) {
            answer = Math.max(answer, count);
        }

        bw.write(answer + "");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        word = st.nextToken();
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}
