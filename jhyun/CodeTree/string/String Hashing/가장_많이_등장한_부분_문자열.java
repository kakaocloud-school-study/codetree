import java.util.*;

public class Main {
    static final int MAX_N = 100000;

    static String text;
    static int n, l;

    // 2개의 polynomial rolling 해싱을 위한 p, m 값을 정의합니다.
    static int[] p = new int[]{31, 37};
    static int[] m = new int[]{(int)1e9 + 7, (int)1e9 + 9};

    // p^i, 값을 m으로 나눈 나머지를 관리합니다.
    static long[][] pPow = new long[2][MAX_N + 1];

    // 각 문자열이 몇번 나왔는지 정리합니다.
    static HashMap<Long, Integer> freq = new HashMap<>();

    static int ans;

    // 소문자 알파벳을 수로 변경합니다.
    public static int toInt(char c) {
        return c - 'a' + 1;
    }

    // (h1, h2) 값으로 unique한 값을 만들어줍니다.
    public static long genUniqueKey(long h1, long h2) {
        return h1 * Math.max(m[0], m[1]) + h2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        l = sc.nextInt();
        text = sc.next();

        n = text.length();

        // pPow 값을 계산합니다.
        // pPow[i] = p^i % m
        for(int k = 0; k < 2; k++) {
            pPow[k][0] = 1;
            for(int i = 1; i <= n; i++)
                pPow[k][i] = (pPow[k][i - 1] * p[k]) % m[k];
        }

        // text에서 구간 [0, l - 1]에 해당하는 해싱값을 계산합니다.
        long[] tH = new long[2];
        for(int k = 0; k < 2; k++) {
            for(int i = 0; i < l; i++)
                tH[k] = (tH[k] + toInt(text.charAt(i)) * pPow[k][l - 1 - i]) % m[k];
        }

        // 해싱된 값을 map에 저장합니다.
        long key = genUniqueKey(tH[0], tH[1]);
        freq.put(key, freq.getOrDefault(key, 0) + 1);
        ans = Math.max(ans, freq.get(key));

        // text에서
        // 길이가 l인 부분문자열을 전부 잡아보며
        // 해싱값을 전부 map에 저장합니다.
        for(int i = 1; i <= n - l; i++) {
            // 이전 [i - 1, i + l - 2]에 해당하는 해싱값은 tH에 있습니다.
            // 이전 값(tH)은 (text[i - 1] * p^(l - 1) + text[i] * p^(l - 2) + ... + text[i + l - 2] * 1) % m입니다.
            // 이제 tH * p - text[i - 1] * p^l + text[i + l - 1]를 계산하면
            // 새로 계산을 원하는 해싱값인 (text[i] * p^(l - 1) + text[i + 1] * p(l - 2) + ... + text[i + l - 1] * 1) % m이 됩니다.
            for(int k = 0; k < 2; k++) {
                tH[k] = (tH[k] * p[k] - toInt(text.charAt(i - 1)) * pPow[k][l] + toInt(text.charAt(i + l - 1))) % m[k];
                // tH값을 양수로 변환해줍니다.
                if(tH[k] < 0)
                    tH[k] += m[k];
            }

            key = genUniqueKey(tH[0], tH[1]);
            freq.put(key, freq.getOrDefault(key, 0) + 1);
            ans = Math.max(ans, freq.get(key));
        }

        System.out.print(ans);
    }
}