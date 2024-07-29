import java.util.*;
import java.io.*;

public class Main {
    static final int MAX_N = 100000;
    static int[] A = new int[MAX_N + 1];
    static int[] B = new int[MAX_N + 1];

    static int n, m;

    static boolean isSubsequence() {
        int i = 1;

        //B의 원소를 기준으로 순서대로 매칭 가능한지 확인
        for (int j = 1; j <= m; j++) {
            //A의 원소가 B의 j번째 원소와 일치해지는 위치 구하기
            while (i <= n && A[i] != B[j]) {
                i++;
            }

            //만약 수열 A에서 일치하는 원소를 찾지 못했다면 부분수열이 아님
            if (i == n + 1) {
                return false;
            } else { //일치한다면 A원소의 위치도 한칸 앞으로 이동
                i++;
            }
        }
        return true; //전부 매칭하는게 가능하다면 부분수열
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= m; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        if (isSubsequence()) {
            System.out.print("Yes");
        } else {
            System.out.print("No");
        }
    }
}