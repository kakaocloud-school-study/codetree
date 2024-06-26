import java.util.*;
import java.io.*;

public class Main {
    static final int INT_MAX = Integer.MAX_VALUE;
    static final int MAX_N = 100000;
    static int[] arr = new int[MAX_N + 1];
    static int n, s;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int ans = INT_MAX;
        int sumVal = 0;
        int j = 0;

        for (int i = 1; i <= n; i++) {
            //구간 내 합이 s보다 작으면 계속 진행
            while (j + 1 <= n && sumVal < s) {
                sumVal += arr[j + 1];
                j++;
            }

            //만약 최대한 이동했는데도 sumVal이 s가 되지 못했다면 탐색 종료
            if (sumVal < s) {
                break;
            }

            //현재 구간 [i,j]는 i를 시작점으로 하는 가장 짧은 구간이므로 구간 크기 중 최솟값을 갱신
            ans = Math.min(ans, j - i + 1);

            //다음 구간으로 넘어가기 전 arr[i]에 해당하는 값은 구간에서 제외
            sumVal -= arr[i];
        }

        if (ans == INT_MAX) {
            ans = -1;
        }

        System.out.print(ans);
    }
}