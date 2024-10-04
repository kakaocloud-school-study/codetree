/*
 * 트리셋으로 풀었지만
 * 해설에서는 a,b 각각 정렬하고 투포인터로 풀이함
 */
package lim.그리디;

import java.util.*;
import java.io.*;

public class Greedy_Algorithm_높은_숫자의_카드가_이기는_게임 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int[] arr;

    static void sol() throws IOException {
        int answer = 0;
        HashSet<Integer> bNums = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            bNums.add(arr[i]);
        }
        TreeSet<Integer> aNums = new TreeSet<>();
        for (int num = 1; num <= 2 * n; num++) {
            if (bNums.contains(num)) {
                continue;
            }
            aNums.add(num);
        }
        for (int i = 0; i < arr.length; i++) {
            Integer candidate = aNums.higher(arr[i]);
            if (candidate == null) {
                aNums.remove(aNums.first());
                continue;
            }
            aNums.remove(candidate);
            answer++;
        }
        bw.write(answer + "");
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}
