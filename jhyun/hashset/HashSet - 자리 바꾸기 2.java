import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_K = 100000;
    public static final int MAX_N = 100000;

    public static void main(String[] args) throws IOException {
        int[] a = new int[MAX_K];
        int[] b = new int[MAX_K];
        int[] arr = new int[MAX_N + 1];
        int[] ans = new int[MAX_N + 1];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        HashSet<Integer>[] hashSet = new HashSet[MAX_N + 1];
        for (int i = 1; i <= n; i++) {
            hashSet[i] = new HashSet<>();
        }

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            a[i] = Integer.parseInt(st.nextToken());
            b[i] = Integer.parseInt(st.nextToken());
        }

        // 초기 자리 기록
        for (int i = 1; i <= n; i++) {
            arr[i] = i;
            hashSet[i].add(i);
            ans[i] = 1;
        }

        // 자리 바꿈 작업 반복 (3k)
        for (int cnt = 0; cnt < 3; cnt++) {
            for (int i = 0; i < k; i++) {
                //a[i]와 b[i] 자리 바꾸기
                int tmp = arr[a[i]];
                arr[a[i]] = arr[b[i]];
                arr[b[i]] = tmp;

                // 각 자리 바꾸기 작업에서 arr 배열을 업데이트하고, 자리의 방문 기록을 갱신합니다.
                // 새로운 자리에서 방문한 숫자를 hashSet에 추가하고, 방문 횟수를 ans 배열에 업데이트합니다.
                if (!hashSet[arr[a[i]]].contains(a[i])) {
                    hashSet[arr[a[i]]].add(a[i]);
                    ans[arr[a[i]]]++;
                }

                if (!hashSet[arr[b[i]]].contains(b[i])) {
                    hashSet[arr[b[i]]].add(b[i]);
                    ans[arr[b[i]]]++;
                }
            }
        }

        // 결과 출력
        for (int i = 1; i <= n; i++) {
            System.out.println(ans[i]);
        }
    }
}
