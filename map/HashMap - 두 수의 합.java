import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_N = 100000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long[] arr = new long[MAX_N];
        Map<Long, Integer> map = new HashMap<>();

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        /**
         * 구하고자 하는 값(k)에서 arr[i]를 뺀 값이 없다면 map에 넣기!
         * 만약 이미 존재하는 상태라면 value + 1 ex. 6 = 3 + 3
         * 그리고 map에 구하고자 하는 값이 존재하는 경우 value를 res에 더하기!
         */

        int res = 0;
        for (int i = 0; i < n; i++) {
            long diff = k - arr[i];
            if (map.containsKey(diff)) {
                res += map.get(diff);
            }

            if (!map.containsKey(arr[i])) {
                map.put(arr[i], 1);
            } else {
                map.put(arr[i], map.get(arr[i]) + 1);
            }
        }
        System.out.print(res);
    }
}