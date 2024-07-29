import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static List<Integer> combination = new ArrayList<>();

    static void printCombination() {
        for (int i = 0; i < combination.size(); i++) {
            System.out.print(combination.get(i) + " ");
        }
        System.out.println();
    }

    static void findCombination(int curNum, int cnt) {
        if (curNum == n + 1) {
            if (cnt == m) {
                printCombination();
            }
            return;
        }

        //curNum에 해당하는 숫자를 사용했을 때의 경우 탐색
        combination.add(curNum);
        findCombination(curNum + 1, cnt + 1);
        combination.remove(combination.size() - 1);

        //curNum에 해당하는 숫자를 사용하지 않았을 때의 경우 탐색
        findCombination(curNum + 1, cnt);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        findCombination(1, 0);
    }
}