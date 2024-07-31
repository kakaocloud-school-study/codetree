package jhyun.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class BOJ4179 {
    static int n, m;
    static char[][] map;
    static int[][] fireDist;
    static int[][] jhDist;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Queue<Pair> fireQueue;
    static Queue<Pair> jhQueue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        fireDist = new int[n][m];
        jhDist = new int[n][m];
        fireQueue = new LinkedList<>();
        jhQueue = new LinkedList<>();

        init(br);

        // 불에 대한 BFS
        fireBFS();

        // 지훈에 대한 BFS
        if (jhBFS()) {
            return;
        }
        System.out.println("IMPOSSIBLE");
    }

    private static boolean jhBFS() {
        while (!jhQueue.isEmpty()) {
            Pair cur = jhQueue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                // 범위를 벗어났다는 것은 탈출에 성공했다는 의미
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    System.out.println(jhDist[cur.x][cur.y] + 1);
                    return true;
                }
                if (jhDist[nx][ny] >= 0 || map[nx][ny] == '#') {
                    continue;
                }
                // 불의 전파 시간을 조건에 추가
                if (fireDist[nx][ny] != -1 && fireDist[nx][ny] <= jhDist[cur.x][cur.y] + 1) {
                    continue;
                }
                jhDist[nx][ny] = jhDist[cur.x][cur.y] + 1;
                jhQueue.offer(new Pair(nx, ny));
            }
        }
        return false;
    }

    private static void fireBFS() {
        while (!fireQueue.isEmpty()) {
            Pair cur = fireQueue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }
                if (fireDist[nx][ny] >= 0 || map[nx][ny] == '#') {
                    continue;
                }
                fireDist[nx][ny] = fireDist[cur.x][cur.y] + 1;
                fireQueue.offer(new Pair(nx, ny));
            }
        }
    }

    private static void init(BufferedReader br) throws IOException {
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j);
                fireDist[i][j] = -1;
                jhDist[i][j] = -1;
                if (map[i][j] == 'F') {
                    fireQueue.offer(new Pair(i, j));
                    fireDist[i][j] = 0;
                }
                if (map[i][j] == 'J') {
                    jhQueue.offer(new Pair(i, j));
                    jhDist[i][j] = 0;
                }
            }
        }
    }
}