import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[] b = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        HashSet<Integer> hashSet = new HashSet<>();
        for (int num : a) {
            hashSet.add(num);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < b.length; i++) {
            if (hashSet.contains(b[i])) {
                sb.append("1").append("\n");
            } else {
                sb.append("0").append("\n");
            }
        }

        System.out.println(sb.toString());
    }
}