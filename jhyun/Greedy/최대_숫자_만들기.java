import java.util.*;
import java.io.*;

public class Main {
    static final int MAX_N = 50000;
    static int n;
    static Integer[] arr = new Integer[MAX_N];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // a + b 기준 내림차순 정렬
        Arrays.sort(arr, 0, n, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                String s1 = Integer.toString(a) + Integer.toString(b);
                String s2 = Integer.toString(b) + Integer.toString(a);
                return s2.compareTo(s1);
            }
        });

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]);
        }
    }
}