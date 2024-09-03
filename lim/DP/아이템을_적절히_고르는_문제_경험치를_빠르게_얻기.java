/*
 * 해설보다 빠른 풀이
 * 해설 dp[N][TotalTime]
 * 해당 풀이 dp[TotalTime]
 * 해설에서는 퀘스트 인덱스에 대한 차원을 부여하면서 중복없는 조합으로 dp를 갱신했다
 * 해당 풀이에서는 dp 갱신을 역순으로 하는 테크닉으로 중복없는 조합으로 dp를 갱신했다
*/
package lim.DP;

import java.util.*;
import java.io.*;

public class 아이템을_적절히_고르는_문제_경험치를_빠르게_얻기 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] maxExpByTime;
    static Quest[] quests;
    static int m;

    static class Quest {
        int exp, time;

        Quest(int exp, int time) {
            this.exp = exp;
            this.time = time;
        }
    }

    static void sol() throws IOException {
        for (int currTimeSum = maxExpByTime.length - 1; currTimeSum >= 1; currTimeSum--) {
            maxExpByTime[currTimeSum] = -1;
        }
        for (int i = 0; i < quests.length; i++) {
            Quest quest = quests[i];
            for (int currTimeSum = maxExpByTime.length - 1; currTimeSum >= 1; currTimeSum--) {
                int prevTimeSum = currTimeSum - quest.time;
                if (prevTimeSum < 0 || maxExpByTime[prevTimeSum] == -1) {
                    continue;
                }
                maxExpByTime[currTimeSum] = Math.max(maxExpByTime[currTimeSum], maxExpByTime[prevTimeSum] + quest.exp);
            }
        }

        int answer = -1;
        for (int i = 1; i < maxExpByTime.length; i++) {
            if (maxExpByTime[i] >= m) {
                answer = i;
                break;
            }
        }
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        maxExpByTime = new int[10001];
        quests = new Quest[n];
        for (int i = 0; i < quests.length; i++) {
            st = new StringTokenizer(br.readLine());
            quests[i] = new Quest(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        sol();
        br.close();
    }
}
