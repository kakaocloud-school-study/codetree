package lim.미분류;

import java.io.*;
import java.util.*;

public class 소프티어_lv2_6283_8단_변속기 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static ArrayList<String> arr = new ArrayList<>();

    static void sol() throws IOException {
        String line = String.join("", arr);
        if ("12345678".equals(line)) {
            bw.write("ascending");
        } else if ("87654321".equals(line)) {
            bw.write("descending");
        } else {
            bw.write("mixed");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 8; i++) {
            arr.add(st.nextToken());
        }

        sol();

        br.close();
        bw.flush();
        bw.close();
    }
}
