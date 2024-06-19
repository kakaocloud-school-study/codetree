import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr1 = new int[n];
        int[] arr2 = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        //쌍의 합이 작은 순서대로 쌍을 관리
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> arr1[o[0]] + arr2[o[1]]));

        //init : [arr1의 idx, 0]
        for (int i = 0; i < n; i++) {
            pq.offer(new int[]{i, 0});
        }

        int count = 0;
        int result = 0;

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int i = current[0];
            int j = current[1];
            result = arr1[i] + arr2[j];
            count++;

            if (count == k) {
                break;
            }

            //index가 arr 범위 벗어나지 않도록 새로운 쌍 추가
            if (j + 1 < m) {
                pq.offer(new int[]{i, j + 1});
            }
        }

        System.out.println(result);
    }
}