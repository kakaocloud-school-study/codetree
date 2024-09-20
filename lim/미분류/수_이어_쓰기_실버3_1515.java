package lim.미분류;

import java.util.*;
import java.io.*;

// 8 (1)2 (1)3 (1)4 (2)0 (2)3 2(4) (2)9 (3)9 (4)2 (4)3
// 3 (1)2 (2)0 (2)9 (3)8 (4)2 (5)2 (6)1

public class 수_이어_쓰기_실버3_1515 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static String word;

    static void sol() throws IOException {
        int currNum = 1;
        int wordIdx = 0;
        while (true) {
            String nums = String.valueOf(currNum);
            int numIdx = 0;
            while (wordIdx < word.length()) {
                char ch = word.charAt(wordIdx);
                while (numIdx < nums.length() && nums.charAt(numIdx) != ch) {
                    numIdx++;
                }
                if (numIdx < nums.length() && nums.charAt(numIdx) == ch) {
                    numIdx++;
                    wordIdx++;
                } else {
                    break;
                }
            }
            if (wordIdx < word.length()) {
                currNum++;
            } else {
                break;
            }
        }
        bw.write(currNum + "");
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
