import java.util.*;
import java.io.*;

public class Main {
    static int k, n;
    static List<Integer> selectedNums = new ArrayList<>();

    static void printPermutation() {
        for (int i = 0; i < selectedNums.size(); i++) {
            System.out.print(selectedNums.get(i) + " ");
        }
        System.out.println();
    }

    static void findPermutations(int cnt) {
        if (cnt == n) {
            printPermutation();
            return;
        }

        for (int i = 1; i <= k; i++) {
            selectedNums.add(i);
            findPermutations(cnt + 1);
            selectedNums.remove(selectedNums.size() - 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        findPermutations(0);
    }
}