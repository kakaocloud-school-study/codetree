package lim.문자열;

// import java.util.*;
import java.io.*;

public class KMP_부분_문자열_등장_횟수 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static String pattern, word;

    static void sol() throws IOException {
        int[] f = new int[pattern.length()];
        f[0] = -1;
        for (int i = 1; i < f.length; i++) {
            int j = f[i - 1];
            while (j >= 0 && pattern.charAt(j + 1) != pattern.charAt(i)) {
                j = f[j];
            }
            f[i] = j + 1;
        }

        int j = 0;
        int answer = 0;
        for (int i = 1; i < word.length(); i++) {
            while (j >= 0 && pattern.charAt(j + 1) != word.charAt(i)) {
                j = f[j];
            }
            j++;
            if (j == pattern.length() - 1) {
                answer++;
                j = f[j];
            }
        }

        bw.write(answer + "");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        word = '#' + br.readLine();
        pattern = '#' + br.readLine();
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}
