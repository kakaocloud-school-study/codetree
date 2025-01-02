package lim.map;

import java.util.*;
import java.io.*;

public class 실버4_1620_나는야_포켓몬_마스터_이다솜 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static String[] names, queries;

    static void sol() throws IOException {
        HashMap<String, Integer> numByName = new HashMap<>();
        HashMap<Integer, String> nameByNum = new HashMap<>();
        for (int i = 0; i < names.length; i++) {
            int num = i + 1;
            numByName.put(names[i], num);
            nameByNum.put(num, names[i]);
        }
        for (String query : queries) {
            try {
                String name = nameByNum.get(Integer.parseInt(query));
                bw.write(name + "\n");
            } catch (Exception e) {
                int num = numByName.get(query);
                bw.write(num + "\n");
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        names = new String[n];
        queries = new String[m];

        for (int i = 0; i < n; i++) {
            names[i] = br.readLine();
        }
        for (int i = 0; i < m; i++) {
            queries[i] = br.readLine();
        }

        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}