import java.util.*;
import java.io.*;

public class Main {
    static final int MAX_N = 100000;
    static Map<Character, Integer> countArray = new HashMap<>();

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String word = br.readLine();
        int n = word.length();

        word = "#" + word;

        int ans = 0;

        int j = 0;
        for (int i = 1; i <= n; i++) {
            // 같은 문자가 2개가 되기 전까지 계속 진행합니다.
            while (j + 1 <= n && countArray.getOrDefault(word.charAt(j + 1), 0) != 1) {
                char c = word.charAt(j + 1);
                countArray.put(c, countArray.getOrDefault(c, 0) + 1);
                j++;
            }

            // 현재 구간 [i, j]는 i를 시작점으로 하는 가장 긴 구간이므로 구간 크기 중 최댓값을 갱신
            ans = Math.max(ans, j - i + 1);

            // 다음 구간으로 넘어가기 전에 word[i]에 해당하는 값은 countArray에서 지워줌
            countArray.put(word.charAt(i), countArray.get(word.charAt(i)) - 1);
        }

        System.out.print(ans);
    }
}