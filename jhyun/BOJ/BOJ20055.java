package CodingTest.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] belt = new int[N*2];
        boolean[] robot = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N*2; i++) {
            belt[i] = Integer.parseInt(st.nextToken());
        }

        int level = 0;

        while(true) {
            level++;

            //1단계
            moveBeltAndRobot(belt, N, robot);

            //2단계
            rotateBelt(N, robot, belt);

            //3단계
            raiseRobot(belt, robot);

            //4단계
            if (checkProcess(N, belt, K)) {
                break;
            }
        }
        System.out.println(level);
    }

    private static boolean checkProcess(int N, int[] belt, int K) {
        int cnt = 0;
        for (int i = 0; i < 2 * N; i++) {
            if (belt[i] == 0) {
                cnt++;
            }
        }
        if (cnt >= K) {
            return true;
        }
        return false;
    }

    private static void raiseRobot(int[] belt, boolean[] robot) {
        if (belt[0] > 0) {
            robot[0] = true;
            belt[0]--;
        }
    }

    private static void rotateBelt(int N, boolean[] robot, int[] belt) {
        for (int i = N - 1; i > 0; i--) {
            if (robot[i - 1] && !robot[i] && belt[i] > 0) {
                robot[i - 1] = false;
                robot[i] = true;
                belt[i]--;
                robot[N - 1] = false;
            }
        }
    }

    private static void moveBeltAndRobot(int[] belt, int N, boolean[] robot) {
        int tmp = belt[2 * N - 1];
        for (int i = 2 * N -1; i > 0; i--) {
            belt[i] = belt[i - 1];
        }
        belt[0] = tmp;

        for (int i = N - 1; i > 0; i--) {
            robot[i] = robot[i - 1];
        }

        robot[0] = false;
        robot[N - 1] = false;
    }
}