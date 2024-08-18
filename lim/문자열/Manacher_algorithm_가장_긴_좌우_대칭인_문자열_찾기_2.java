package lim.문자열;

// import java.util.*;
import java.io.*;

public class Manacher_algorithm_가장_긴_좌우_대칭인_문자열_찾기_2 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static String word;

    static void sol() throws IOException {
        char[] chars = new char[2 * word.length() + 1];
        int[] mLens = new int[chars.length];
        chars[0] = '#';
        for (int i = 0; i < word.length(); i++) {
            chars[2 * i + 1] = word.charAt(i);
            chars[2 * i + 2] = '#';
        }

        int pEnd = -1;
        int pEndMid = -1;
        for (int i = 0; i < mLens.length; i++) {
            if (pEnd < i) {
                mLens[i] = 0;
            } else {
                int ii = (2 * pEndMid) - i;
                mLens[i] = Math.min(pEnd - i, mLens[ii]);
            }

            while (i - (mLens[i] + 1) >= 0 && i + (mLens[i]
                    + 1) < chars.length && chars[i - (mLens[i] + 1)] == chars[i + (mLens[i] + 1)]) {
                mLens[i]++;
            }
            if (pEnd < i + mLens[i]) {
                pEnd = i + mLens[i];
                pEndMid = i;
            }
        }

        int answer = 1;

        for (int i = 0; i < mLens.length; i++) {
            answer = Math.max(answer, mLens[i] * 2 + 1);
        }

        bw.write(answer / 2 + "");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        word = br.readLine();
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}
