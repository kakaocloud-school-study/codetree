import java.util.*;
import java.io.*;

public class Main {
    static final int MAX_N = 100000;
    static int[] arr = new int[MAX_N + 1];

    static int n, k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        //two pointer를 적용하기 위해 주어진 숫자들 정렬
        Arrays.sort(arr, 1, n + 1);

        int ans = 0;

        //숫자 i에 대해 arr[i] + arr[j] <= k를 만족하는 j 중 최대의 j가 잡히도록 two pointer 진행
        int j = n;
        for (int i = 1; i <= n; i++) {
            //구간 내 합이 k보다 크면 계속 진행
            while (j != 1 && arr[i] + arr[j] > k) {
                j--;
            }

            //j가 i보다 같거나 작아져야만 두 숫자의 합이 k 이내가 됨
            if (j <= i) {
                break;
            }

            //현재 숫자 arr[i]에 대해 [i+1, j] 내에 있는 모든 숫자가 정확히
            //arr[i]와 합이 k 이하가 되는 경우임을 확신할 수 있으므로 j - i를 답에 더해줌
            ans += j - i;
        }

        System.out.print(ans);
    }
}