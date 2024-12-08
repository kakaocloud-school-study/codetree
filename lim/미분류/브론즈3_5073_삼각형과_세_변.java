package lim.미분류;

import java.util.*;
import java.io.*;

public class 브론즈3_5073_삼각형과_세_변 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static ArrayList<ArrayList<Integer>> queries = new ArrayList<>();

    static void sol() throws IOException {
        Map<Integer, String> nameByCombo = Map.of(
                3, "Scalene",
                2, "Isosceles",
                1, "Equilateral");
        for (ArrayList<Integer> query : queries) {
            query.sort(null);
            if (query.get(0) + query.get(1) <= query.get(2)) {
                bw.write("Invalid\n");
                continue;
            }
            bw.write(nameByCombo.get((new HashSet<>(query)).size()) + "\n");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (a == 0) {
                break;
            }
            queries.add(new ArrayList<>(List.of(a, b, c)));
        }

        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}
