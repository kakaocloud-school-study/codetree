import java.util.*;
import java.io.*;

public class Main {
    static final int DIR_NUM = 4;
    static final int MAX_NUM = 25;

    static int n;
    static int[][] grid = new int[MAX_NUM][MAX_NUM];
    static boolean[][] visited = new boolean[MAX_NUM][MAX_NUM];
    static List<Integer> peopleNums = new ArrayList<>();
    static int peopleNum;

    static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }

    static boolean canGo(int x, int y) {
        if (!inRange(x, y)) {
            return false;
        }
        if (visited[x][y] || grid[x][y] == 0) {
            return false;
        }
        return true;
    }

    static void DFS(int x, int y) {
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};

        for (int dir = 0; dir < DIR_NUM; dir++) {
            int newX = x + dx[dir];
            int newY = y + dy[dir];

            if (canGo(newX, newY)) {
                visited[newX][newY] = true;
                peopleNum++;
                DFS(newX, newY);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (canGo(i, j)) {
                    visited[i][j] = true;
                    peopleNum = 1;

                    DFS(i, j);

                    peopleNums.add(peopleNum);
                }
            }
        }

        Collections.sort(peopleNums);

        System.out.println(peopleNums.size());
        for (int i = 0; i < peopleNums.size(); i++) {
            System.out.println(peopleNums.get(i));
        }
    }
}