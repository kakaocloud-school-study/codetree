package lim.투포인터;

import java.io.*;

public class 실버1_5525_IOIOI {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int patternLen;
    static String line;

    static void sol() throws IOException {
        int count = 0;
        int eIdx = 0;
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == 'O') {
                continue;
            }
            eIdx = Math.max(i + 2, eIdx);
            while (eIdx < line.length() && line.charAt(eIdx - 1) == 'O' && line.charAt(eIdx) == 'I') {
                if (eIdx - i + 1 == patternLen) {
                    count++;
                    break;
                }
                eIdx += 2;
            }
        }

        bw.write(count + "");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        patternLen = Integer.parseInt(br.readLine()) * 2 + 1;
        br.readLine();
        line = br.readLine();

        sol();

        br.close();
        bw.flush();
        bw.close();
    }
}
