import java.util.*;
import java.io.*;

public class Main {
    static final int MAX_N = 200;
    static int[] u = new int[MAX_N + 1];
    static int[] d = new int[MAX_N + 1];
    static int n, t;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            u[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            d[i] = Integer.parseInt(st.nextToken());
        }

        while (t-- > 0) {
            //위에서 가장 오른쪽에 있는 숫자를 따로 temp에 저장
            int temp = u[n - 1];

            //위에 있는 숫자 오른쪽으로 밀기
            for (int i = n - 1; i >= 1; i--) {
                u[i] = u[i - 1];
            }
            //맨 왼쪽 숫자는 아래에서 가져오기
            u[0] = d[n - 1];

            //아래에 있는 숫자 왼쪽으로 밀기
            for (int i = n - 1; i >= 1; i--) {
                d[i] = d[i - 1];
            }
            //맨 왼쪽 숫자는 temp에서 가져오기
            d[0] = temp;
        }

        for (int i = 0; i < n; i++) {
            System.out.print(u[i] + " ");
        }
        System.out.println();

        for (int i = 0; i < n; i++) {
            System.out.print(d[i] + " ");
        }
        System.out.println();
    }
}