package lim.그리디;

import java.io.*;

public class 실버2_1541_잃어버린_괄호 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static String line;

    static void sol() throws IOException {
        int total = 0;
        boolean isMinus = false;
        String num = "";
        for (char ch : line.toCharArray()) {
            if (ch == '+' || ch == '-') {
                if (isMinus) {
                    total -= Integer.parseInt(num);
                    num = "";
                } else {
                    total += Integer.parseInt(num);
                    num = "";
                }
                if (ch == '-') {
                    isMinus = true;
                }
            } else {
                num += ch;
            }
        }
        if (isMinus) {
            total -= Integer.parseInt(num);
            num = "";
        } else {
            total += Integer.parseInt(num);
            num = "";
        }
        bw.write(total + "");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        line = br.readLine();
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}