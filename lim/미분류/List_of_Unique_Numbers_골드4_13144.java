package lim.미분류;

import java.util.*;
import java.io.*;

public class List_of_Unique_Numbers_골드4_13144 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int[] arr;

    static void sol() throws IOException {
        long count = 0;
        HashSet<Integer> wnd = new HashSet<>();
        int eIdx = 0;
        for (int sIdx = 0; sIdx < arr.length; sIdx++) {
            while (eIdx < arr.length && !wnd.contains(arr[eIdx])) {
                wnd.add(arr[eIdx++]);
            }
            count += eIdx - sIdx;
            wnd.remove(arr[sIdx]);
        }
        bw.write(count + "");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}