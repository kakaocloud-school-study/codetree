import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_N = 4000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] A = new int[MAX_N];
        int[] B = new int[MAX_N];
        int[] C = new int[MAX_N];
        int[] D = new int[MAX_N];
        Map<Integer, Integer> map = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            C[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            D[i] = Integer.parseInt(st.nextToken());
        }

        long ans = 0;

        // 원소 A, B의 합으로 key를 구해서 map에 저장
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int key = A[i] + B[j];
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
        }

        // 원소 C, D의 합이 key에 저장된 값이라면 (A, B의 합과 일치하다면) 경우의 수를 더해줌
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int diff = -C[i] - D[j];
                if (map.getOrDefault(diff, 0) > 0) {
                    ans += map.get(diff);
                }
            }
        }

        System.out.println(ans);
    }
}