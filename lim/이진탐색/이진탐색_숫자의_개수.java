import java.util.*;
import java.io.*;

public class 이진탐색_숫자의_개수 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m;
    static int[] arr, queries;

    static int findLIdx(int targetNum) {
        int left = 0, right = arr.length - 1;
        int idx = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] >= targetNum) {
                right = mid - 1;
                if (arr[mid] == targetNum) {
                    idx = mid;
                }
            } else {
                left = mid + 1;
            }
        }
        return idx;
    }

    static int findUIdx(int targetNum) {
        int left = 0, right = arr.length - 1;
        int idx = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] > targetNum) {
                right = mid - 1;
            } else {
                left = mid + 1;
                if (arr[mid] == targetNum) {
                    idx = mid;
                }
            }
        }
        return idx;
    }

    static void sol() throws IOException {

        for (int targetNum : queries) {
            int lIdx = findLIdx(targetNum);
            int uIdx = findUIdx(targetNum);
            if (lIdx == -1 || uIdx == -1) {
                bw.write("0\n");
                continue;
            }
            bw.write(uIdx - lIdx + 1 + "\n");
        }
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        queries = new int[m];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            queries[i] = Integer.parseInt(st.nextToken());
        }
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}
