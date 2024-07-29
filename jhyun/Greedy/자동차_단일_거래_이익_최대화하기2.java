import java.util.*;
import java.io.*;

public class Main {
    static final int MAX_N = 100000;
    static int n;
    static int[] price = new int[MAX_N];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            price[i] = Integer.parseInt(st.nextToken());
        }

        int maxProfit = 0;
        int minPrice = price[0];
        for (int i = 0; i < n; i++) {
            int profit = price[i] - minPrice;

            if (profit > maxProfit) {
                maxProfit = profit;
            }

            if (minPrice > price[i]) {
                minPrice = price[i];
            }
        }
        System.out.print(maxProfit);
    }
}