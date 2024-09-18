package lim.이진탐색;

/*
 * 판별식을 어렵게 적었는데
 * 해설에서는 수학적으로 좀 더 간단하게 처리함
 */
import java.util.*;
import java.io.*;

public class Parametric_Search_공책과_포스트잇 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, postitCount, numPerPostit;
    static int[] arr;

    static boolean check(int hIndex) {
        int overHIdxCount = 0;
        LinkedList<Integer> postitCountByLevel = new LinkedList<>();
        for (int i = 0; i < numPerPostit; i++) {
            postitCountByLevel.add(postitCount);
        }
        int idx = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= hIndex) {
                break;
            }
            idx = i;
        }
        overHIdxCount = arr.length - idx - 1;
        while (idx >= 0 && !postitCountByLevel.isEmpty() && hIndex - arr[idx] <= postitCount) {
            int citeReq = hIndex - arr[idx];
            if (postitCountByLevel.getLast() < citeReq) {
                citeReq -= postitCountByLevel.getLast();
                postitCountByLevel.pollLast();
            }
            if (!postitCountByLevel.isEmpty()) {
                int newCount = postitCountByLevel.pollLast() - citeReq;
                if (newCount > 0) {
                    postitCountByLevel.offerLast(newCount);
                }
                overHIdxCount++;
            }
            idx--;
        }
        return overHIdxCount >= hIndex;
    }

    static void sol() throws IOException {
        Arrays.sort(arr);
        int left = 0, right = 100_000;
        int answer = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (check(mid)) {
                left = mid + 1;
                answer = mid;
            } else {
                right = mid - 1;
            }
        }
        bw.write(answer + "");
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        postitCount = Integer.parseInt(st.nextToken());
        numPerPostit = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}
