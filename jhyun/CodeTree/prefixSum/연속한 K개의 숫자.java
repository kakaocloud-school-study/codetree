import java.util.*;
import java.io.*;

public class Main {
    static final int INT_MAX = Integer.MAX_VALUE;
    static final int MAX_N = 100000;

    static int[] arr = new int[MAX_N + 1];
    static int[] prefixSum = new int[MAX_N + 1];
    static int ans = INT_MAX;

    static int getSum(int s, int e){
        return prefixSum[e] - prefixSum[s-1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        //해당 숫자들이 주어진 자리에 숫자 1 대입
        for(int i = 0; i < b; i++) {
            int x = Integer.parseInt(br.readLine());
            arr[x] = 1;
        }

        prefixSum[0] = 0;
        for(int i = 1; i <= n; i++){
            prefixSum[i] = prefixSum[i-1] + arr[i];
        }

        //모든 구간에 대해 합을 찾아 최솟값 갱신
        for(int i = 1; i <= n - k + 1; i++){
            ans = Math.min(ans, getSum(i, i + k - 1));
        }

        System.out.print(ans);





    }
}