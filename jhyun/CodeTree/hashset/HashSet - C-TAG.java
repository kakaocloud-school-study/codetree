import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_N = 500;
    public static Set<String> hashSet = new HashSet<>();
    public static int n, m;
    public static int ans;
    public static String[] A = new String[MAX_N];
    public static String[] B = new String[MAX_N];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            A[i] = st.nextToken();
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            B[i] = st.nextToken();
        }

        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                for (int k = j + 1; k < m; k++) {
                    // i, j, k 번째 자리를 선택했을 때 두 그룹을 구분 가능한지 확인
                    if (testLocation(i, j, k)) {
                        ans++;
                    }
                }
            }
        }

        System.out.println(ans);
    }

    public static boolean testLocation(int x, int y, int z) {
        hashSet = new HashSet<>();

        // hashSet에 A 원소 삽입
        for (int i = 0; i < n; i++) {
            hashSet.add(A[i].substring(x, x + 1) + A[i].substring(y, y + 1) + A[i].substring(z, z + 1));
        }

        // hashSet 값에 B 원소가 하나라도 있다면 false
        for (int i = 0; i < n; i++) {
            if (hashSet.contains(B[i].substring(x, x + 1) + B[i].substring(y, y + 1) + B[i].substring(z, z + 1))) {
                return false;
            }
        }
        return true;
    }
}