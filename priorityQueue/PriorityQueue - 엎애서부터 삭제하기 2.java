import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_N = 100000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[MAX_N];
        int sumVal = 0;
        double maxAvg = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //뒤에서 부터 1개씩 추가해서 maxAvg 구하기 
        pq.add(arr[n - 1]);
        sumVal += arr[n - 1];
        
        for (int i = n - 2; i >= 1; i--) {
            pq.add(arr[i]);
            sumVal += arr[i];

            double avg = (double) (sumVal - pq.peek()) / (n - i - 1);
            if (maxAvg < avg) {
                maxAvg = avg;
            }
        }

        System.out.printf("%.2f", maxAvg);
    }
}