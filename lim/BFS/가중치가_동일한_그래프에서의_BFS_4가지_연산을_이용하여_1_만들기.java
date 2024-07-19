package lim.BFS;

import java.util.*;
import java.io.*;

public class 가중치가_동일한_그래프에서의_BFS_4가지_연산을_이용하여_1_만들기 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static HashSet<Integer> visited = new HashSet<>();
    static int n, m;
    static int answer = Integer.MAX_VALUE;

    static class Pair {
        int num1, num2;

        Pair(int num1, int num2) {
            this.num1 = num1;
            this.num2 = num2;
        }
    }

    static void bfs(int num) {
        LinkedList<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(num, 0));
        visited.add(num);

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            num = pair.num1;
            int ops = pair.num2;
            if (num == 1) {
                answer = Math.min(answer, ops);
                continue;
            }

            if (!visited.contains(num - 1)) {
                visited.add(num - 1);
                queue.offer(new Pair(num - 1, ops + 1));
            }
            if (num <= n && !visited.contains(num + 1)) {
                visited.add(num + 1);
                queue.offer(new Pair(num + 1, ops + 1));
            }
            if (num % 2 == 0 && !visited.contains(num / 2)) {
                visited.add(num / 2);
                queue.offer(new Pair(num / 2, ops + 1));
            }
            if (num % 3 == 0 && !visited.contains(num / 3)) {
                visited.add(num / 3);
                queue.offer(new Pair(num / 3, ops + 1));
            }
        }
    }

    static void sol() throws IOException {
        bfs(n);
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        sol();
        br.close();
    }
}
