package lim.투포인터;

import java.util.*;
import java.io.*;

public class Two_Pointer_겹치는_숫자가_없는_최대_구간 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int[] arr;

    static void sol() throws IOException {
        int answer = 0;
        HashSet<Integer> nums = new HashSet<>();
        int eIdx = 0;
        for (int i = 0; i < arr.length; i++) {
            while (eIdx < arr.length && !nums.contains(arr[eIdx])) {
                nums.add(arr[eIdx++]);
            }
            answer = Math.max(answer, eIdx - i);
            nums.remove(arr[i]);
        }
        bw.write(answer + "");
    }

    public static void main(String[] args) throws IOException {
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
