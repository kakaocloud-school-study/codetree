package lim.시뮬레이션;

import java.io.*;
import java.util.*;

public class 소프티어_lv2_6268_전광판 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] digits = {
            0b1110111,
            0b0010010,
            0b1011101,
            0b1011011,
            0b0111010,
            0b1101011,
            0b1101111,
            0b1110010,
            0b1111111,
            0b1111011
    };
    static String src, dest;

    static int countLights(int digit) {
        int count = 0;
        while (digit > 0) {
            if (digit % 2 == 1) {
                count++;
            }
            digit >>= 1;
        }
        return count;
    }

    static void sol() throws IOException {
        int[] srcArr = new int[5];
        int[] destArr = new int[5];
        for (int i = 0; i < src.length(); i++) {
            srcArr[i + 5 - src.length()] = digits[src.charAt(i) - '0'];
        }
        for (int i = 0; i < dest.length(); i++) {
            destArr[i + 5 - dest.length()] = digits[dest.charAt(i) - '0'];
        }

        int count = 0;
        for (int i = 0; i < destArr.length; i++) {
            count += countLights(srcArr[i] ^ destArr[i]);
        }
        bw.write(count + "\n");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            src = st.nextToken();
            dest = st.nextToken();
            sol();
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
