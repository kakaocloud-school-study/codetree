import java.util.*;
import java.io.*;

public class Main {
    static int MAX_N = 200000;
    static int[] R = new int[MAX_N];
    static int[] arr = new int[MAX_N];
    static int n, k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        //R 배열을 채운다.
        //R[i] = i + 1 번째부터 N번째까지 있는 숫자들 중 arr[i]와 숫자가 같은 폭탄 중
        //가장 가까이 있는 폭탄의 index 만약 그런 폭탄이 없다면 -1 넣기
        Map<Integer, Integer> latestIndex = new HashMap<>();
        for (int i = n - 1; i >= 0; i--) {
            if (!latestIndex.containsKey(arr[i])) {
                R[i] = -1;
            } else {
                R[i] = latestIndex.get(arr[i]);
            }
            latestIndex.put(arr[i], i);
        }

        int ans = -1;
        for (int i = 0; i < n; i++) {
            if (R[i] != -1 && R[i] - i <= k) {
                ans = Math.max(ans, arr[i]);
            }
        }

        System.out.print(ans);
    }
}