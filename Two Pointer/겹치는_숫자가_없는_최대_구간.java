import java.util.*;
import java.io.*;

public class Main {
    static final int MAX_R = 100000;
    static final int MAX_N = 100000;
    static int[] arr = new int[MAX_N + 1];
    static int[] countArray = new int[MAX_R + 1];

    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;
        int j = 0;
        for (int i = 1; i <= n; i++) {
            //같은 숫자가 2개가 되지 전까지 계속 진행
            while (j + 1 <= n && countArray[arr[j + 1]] != 1) {
                countArray[arr[j + 1]]++;
                j++;
            }

            //현재 구간 [i,j]는 i를 시작점으로 하는 가장 긴 구간이므로 구간 크기 중 최댓값을 갱신
            ans = Math.max(ans, j - i + 1);

            //다음 구간으로 넘어가기 전에 arr[i]에 해당하는 값은 countArray에서 지워줌
            countArray[arr[i]]--;
        }

        System.out.print(ans);
    }
}