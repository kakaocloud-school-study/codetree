import java.util.*;
import java.io.*;

public class Main {
    static final int MAX_NUM = 20;

    static int n, m;
    static int[] arr = new int[MAX_NUM];
    static int ans;


    static void findMaxXor(int currIdx, int cnt, int currVal) {
        if (cnt == m) {
            ans = Math.max(currVal, ans);
            return;
        }

        if (currIdx == n) {
            return;
        }

        //currIdx index에 있는 숫자를 선택하지 않은 경우
        findMaxXor(currIdx + 1, cnt, currVal);

        //currIdx index에 있는 숫자를 선택한 경우
        findMaxXor(currIdx + 1, cnt + 1, currVal ^ arr[currIdx]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        findMaxXor(0, 0, 0);

        System.out.print(ans);
    }
}