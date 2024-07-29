import java.util.*;
import java.io.*;

public class Main {
    static final int MAX_N = 8;

    static int n;
    static boolean[] visited = new boolean[MAX_N + 1];
    static List<Integer> picked = new ArrayList<>();

    static void getPermutation(int cnt) {
        if (cnt == n) {
            for (int i = 0; i < picked.size(); i++) {
                System.out.print(picked.get(i) + " ");
            }
            System.out.println();
        }

        for (int i = n; i >= 1; i--) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            picked.add(i);

            getPermutation(cnt + 1);

            visited[i] = false;
            picked.remove(picked.size() - 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        getPermutation(0);
    }
}