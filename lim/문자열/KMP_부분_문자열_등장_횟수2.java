package lim.문자열;

// import java.util.*;
import java.io.*;
import java.util.StringTokenizer;

public class KMP_부분_문자열_등장_횟수2 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static String word;
    static String[] queries;

    static int getCount(String pattern) {
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
        int count = 0;
        for (int i = 1; i < word.length(); i++) {
            while (j >= 0 && pattern.charAt(j + 1) != word.charAt(i)) {
                j = f[j];
            }
            j++;
            if (j == pattern.length() - 1) {
                count++;
                j = f[j];
            }
        }
        return count;
    }

    static void sol() throws IOException {
        for (String pattern : queries) {
            bw.write(getCount(pattern) + "\n");
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        word = '#' + st.nextToken();
        int n = Integer.parseInt(st.nextToken());
        queries = new String[n];
        for (int i = 0; i < n; i++) {
            queries[i] = '#' + br.readLine();
        }
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}
