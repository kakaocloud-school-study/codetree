package jhyun.BOJ;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


class Coin {
    int value;
    int quantity;

    public Coin(int value, int quantity) {
        this.value = value;
        this.quantity = quantity;
    }
}

public class BOJ1943 {
    static final int MAX_N = 100_000;
    static int n;
    static Coin[] coins;
    static boolean[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int tc = 3;

        while (tc-- > 0) {
            n = Integer.parseInt(br.readLine());
            coins = new Coin[n+1];
            dp = new boolean[MAX_N +1];

            int total = 0;
            for (int i = 1; i <= n; i++) {
                st = new StringTokenizer(br.readLine());
                int value = Integer.parseInt(st.nextToken());
                int quantity = Integer.parseInt(st.nextToken());
                coins[i] = new Coin(value, quantity);
                total += value * quantity; //받은 총 금액
                for (int j = 1; j <= quantity; j++) {
                    dp[value * j] = true; //각 종류의 동전으로 만들 수 있는 액수
                }
            }

            if (total % 2 == 1) {
                System.out.println(0);
                continue;
            } else if (dp[total / 2]) {
                System.out.println(1);
                continue;
            }

            //주어진 동전으로 (total / 2)원을 만들 수 있는지 확인
            func(total);
            System.out.println(dp[total / 2] ? 1 : 0);
        }
    }

    private static void func(int total) {
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            int v = coins[i].value;
            int q = coins[i].quantity;

            for (int j = total / 2; j >= v; j--) {
                if (dp[j - v]) { //dp[j-v]가 가능해야 거기에 동전 하나씩 더해서 다음 액수를 가능하게 만듬
                    //(j-v)원부터 동전 v를 하나씩 사용
                    for (int k = 1; k <= q; k++) {
                        if (j - v + v * k > total / 2) {
                            break; //dp[total/2] 이상으로는 채울 필요 없음
                        }
                        dp[j - v + v * k] = true;
                    }
                }
            }
        }
    }
}