package lim.투포인터;

/*
 * 정렬후 투포인터로 양끝에서 좁혀오면된다
 * 하지만 절대값최소가 목표이기 때문에 음수, 0, 양수 경우의 수를 생각해야함
 * 다행히 포인터 변화에 따라 연속적으로 나오기 때문에 반복 조건과 갱신시점을 신경쓰면된다
 * 포인터 이동 반복 조건을 "합>0"으로 잡고 합이 양수인 경우는 일단 다 갱신해보고 마지막으로 0or음수 한번 갱신해본다
 */
import java.util.*;
import java.io.*;

public class Two_Pointer_0에_가장_가까운_합 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int[] arr;

    static void sol() throws IOException {
        Arrays.sort(arr);

        int answer = Integer.MAX_VALUE;
        int currSum = 0;
        int eIdx = arr.length - 1;
        for (int sIdx = 0; sIdx < arr.length; sIdx++) {
            if (sIdx < eIdx) {
                currSum = Math.abs(arr[sIdx] + arr[eIdx]);
                answer = Math.min(answer, currSum);
            }
            while (sIdx + 1 < eIdx && arr[sIdx] + arr[eIdx] > 0) {
                currSum = Math.abs(arr[sIdx] + arr[--eIdx]);
                answer = Math.min(answer, currSum);
            }
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
