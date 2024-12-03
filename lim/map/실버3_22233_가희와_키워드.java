package lim.map;

import java.util.*;
import java.io.*;

public class 실버3_22233_가희와_키워드 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static HashSet<String> memo = new HashSet<>();
    static ArrayList<ArrayList<String>> queries = new ArrayList<>();

    static void sol() throws IOException {
        for (ArrayList<String> query : queries) {
            for (String word : query) {
                memo.remove(word);
            }
            bw.write(memo.size() + "\n");
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            memo.add(br.readLine());
        }

        for (int i = 0; i < m; i++) {
            String[] words = br.readLine().split(",");
            ArrayList<String> query = new ArrayList<>();
            for (String word : words) {
                query.add(word);
            }
            queries.add(query);
        }

        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}