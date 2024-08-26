package CodingTest.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String balls = br.readLine();
        int cnt = Integer.MAX_VALUE;

        //왼쪽으로 빨간 공 모으기

        cnt = leftRedBall(N, balls, cnt);

        // 왼쪽으로 파란 공 모으기
        cnt = leftBlueBall(N, balls, cnt);

        // 오른쪽으로 빨간 공 모으기
        cnt = rightRedBall(N, balls, cnt);

        // 오른쪽으로 파란 공 모으기
        cnt = rightBlueBall(N, balls, cnt);

        System.out.println(cnt);
    }

    private static int rightBlueBall(int N, String balls, int cnt) {
        int subCnt;
        boolean finish;
        subCnt = 0;
        finish = false;
        for(int i = N -1; i>=0; i--) {
            if(finish && balls.charAt(i) == 'B') {
                subCnt++;
                continue;
            }
            if(balls.charAt(i) == 'R') {
                finish = true;
            }
        }

        return Math.min(cnt, subCnt);
    }

    private static int rightRedBall(int N, String balls, int cnt) {
        boolean finish;
        int subCnt;
        subCnt = 0;
        finish = false;
        for(int i = N -1; i>=0; i--) {
            if(finish && balls.charAt(i) == 'R') {
                subCnt++;
                continue;
            }

            if(balls.charAt(i) == 'B'){
                finish = true;
            }
        }
        cnt = Math.min(cnt, subCnt);
        return cnt;
    }

    private static int leftBlueBall(int N, String balls, int cnt) {
        int subCnt;
        boolean finish;
        subCnt = 0;
        finish = false;
        for(int i = 0; i< N; i++) {
            if(finish && balls.charAt(i) == 'B') {
                subCnt++;
                continue;
            }
            if(balls.charAt(i) == 'R') {
                finish = true;
            }
        }
        cnt = Math.min(cnt, subCnt);
        return cnt;
    }

    private static int leftRedBall(int N, String balls, int cnt) {
        int subCnt = 0;
        boolean finish = false;
        for (int i = 0; i < N; i++) {
            if (finish && balls.charAt(i) == 'R') {
                subCnt++;
                continue;
            }

            if (balls.charAt(i) == 'B') {
                finish = true;
            }
        }
        cnt = Math.min(cnt, subCnt);
        return cnt;
    }
}