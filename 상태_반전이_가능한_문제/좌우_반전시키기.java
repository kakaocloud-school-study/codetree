import java.util.*;
import java.io.*;

public class Main {
    static final int MAX_N = 100;
    static int[] arr = new int[MAX_N];

    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //바로 앞에 칸이 아직 0인 경우, 현재 칸을 꼭 선택해야함
        int ans = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i - 1] == 0) {
                ans++;
                arr[i - 1] = 1;
                arr[i] ^= 1;
                //그 다음 칸이 범위 안에 들어오는 경우에만 반전 진행
                if (i + 1 < n) {
                    arr[i + 1] ^= 1;
                }
            }
        }

        //불가능에 해당하는 조건
        //전부 진행했음에도 마지막 위치에 적힌 숫자가 여전히 0인 경우
        if (arr[n - 1] == 0) {
            ans = -1;
        }

        System.out.print(ans);
    }
}