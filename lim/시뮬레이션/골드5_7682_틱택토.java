package lim.시뮬레이션;

import java.util.*;
import java.io.*;

public class 골드5_7682_틱택토 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static ArrayList<String> lines = new ArrayList<>();

    static boolean check(int sr, int sc, int dr, int dc, char target, String line) {
        for (int i = 0; i < 3; i++) {
            int r = sr + dr * i;
            int c = sc + dc * i;
            int idx = r * 3 + c;
            if (line.charAt(idx) != target) {
                return false;
            }
        }
        return true;
    }

    static boolean valid(String line) {
        int xDiff = 0;
        int dotCount = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int idx = i * 3 + j;
                if (line.charAt(idx) == 'X') {
                    xDiff++;
                } else if (line.charAt(idx) == 'O') {
                    xDiff--;
                } else {
                    dotCount++;
                }
            }
        }
        if (xDiff > 1 || xDiff < 0) {
            return false;
        }

        int xBingoCount = 0, oBingoCount = 0;
        for (int r = 0; r < 3; r++) {
            if (check(r, 0, 0, 1, 'X', line)) {
                xBingoCount++;
            }
            if (check(r, 0, 0, 1, 'O', line)) {
                oBingoCount++;
            }
        }
        for (int c = 0; c < 3; c++) {
            if (check(0, c, 1, 0, 'X', line)) {
                xBingoCount++;
            }
            if (check(0, c, 1, 0, 'O', line)) {
                oBingoCount++;
            }
        }
        if (check(0, 0, 1, 1, 'X', line)) {
            xBingoCount++;
        }
        if (check(0, 0, 1, 1, 'O', line)) {
            oBingoCount++;
        }
        if (check(0, 2, 1, -1, 'X', line)) {
            xBingoCount++;
        }
        if (check(0, 2, 1, -1, 'O', line)) {
            oBingoCount++;
        }

        if (xBingoCount + oBingoCount == 0 && dotCount != 0) {
            return false;
        }
        if (xBingoCount >= 1 && xDiff != 1) {
            return false;
        }
        if (oBingoCount >= 1 && xDiff != 0) {
            return false;
        }
        if (xBingoCount >= 1 && oBingoCount >= 1) {
            return false;
        }

        return true;
    }

    static void sol() throws IOException {
        for (String line : lines) {
            if (valid(line)) {
                bw.write("valid\n");
            } else {
                bw.write("invalid\n");
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while (!(line = br.readLine()).equals("end")) {
            lines.add(line);
        }
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}
