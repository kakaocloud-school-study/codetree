package lim.이진탐색;

/*
 * StringBuilder 필요함
 */
import java.util.*;
import java.io.*;

public class Parametric_Search_부분문자열이_되는_횟수_구하기 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static String aWord, bWord;
    static int[] arr;

    static boolean isSub(String origin, String candidate) {
        int oIdx = 0;
        for (int i = 0; i < candidate.length(); i++) {
            char ch = candidate.charAt(i);
            while (oIdx < origin.length() && origin.charAt(oIdx) != ch) {
                oIdx++;
            }
            if (oIdx >= origin.length()) {
                return false;
            }
            oIdx++;
        }
        return true;
    }

    static boolean check(int count) {
        HashSet<Integer> deletedIdx = new HashSet<>();
        for (int i = 0; i < count; i++) {
            deletedIdx.add(arr[i] - 1);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < aWord.length(); i++) {
            if (deletedIdx.contains(i)) {
                continue;
            }
            sb.append(aWord.charAt(i));
        }
        return isSub(sb.toString(), bWord);
    }

    static void sol() throws IOException {
        int left = 0, right = arr.length;
        int answer = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (check(mid)) {
                left = mid + 1;
                answer = mid;
            } else {
                right = mid - 1;
            }
        }
        bw.write(answer + 1 + "");
    }

    public static void main(String[] args) throws IOException {
        aWord = br.readLine();
        bWord = br.readLine();
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[aWord.length()];
        for (int i = 0; i < aWord.length(); i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}
