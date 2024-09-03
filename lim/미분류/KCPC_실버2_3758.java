package lim.미분류;

import java.util.*;
import java.io.*;

public class KCPC_실버2_3758 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, k, myTeamId, m;
    static Team[] teams;
    static int[][] logs;

    static class Team {
        int totalScore = 0, id, lastTime = 0, submitCount = 0;
        int[] scores;

        Team(int id) {
            this.id = id;
            scores = new int[k + 1];
        }

        void submit(int pId, int score, int time) {
            if (scores[pId] < score) {
                totalScore += score - scores[pId];
                scores[pId] = score;
            }
            lastTime = time;
            submitCount++;
        }
    }

    static void sol() throws IOException {
        teams = new Team[n + 1];
        for (int i = 1; i < n + 1; i++) {
            teams[i] = new Team(i);
        }
        for (int i = 0; i < logs.length; i++) {
            int teamId = logs[i][0];
            int pId = logs[i][1];
            int score = logs[i][2];
            teams[teamId].submit(pId, score, i);
        }
        Arrays.sort(teams, 1, teams.length, (t1, t2) -> {
            if (t1.totalScore == t2.totalScore) {
                if (t1.submitCount == t2.submitCount) {
                    return t1.lastTime - t2.lastTime;
                }
                return t1.submitCount - t2.submitCount;
            }
            return t2.totalScore - t1.totalScore;
        });

        int order = 0;
        for (int i = 1; i < teams.length; i++) {
            if (teams[i].id == myTeamId) {
                order = i;
                break;
            }
        }
        bw.write(order + "\n");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            myTeamId = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            logs = new int[m][3];
            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());
                int teamId = Integer.parseInt(st.nextToken());
                int pId = Integer.parseInt(st.nextToken());
                int score = Integer.parseInt(st.nextToken());
                logs[j][0] = teamId;
                logs[j][1] = pId;
                logs[j][2] = score;
            }
            sol();
        }

        bw.flush();
        bw.close();
        br.close();
    }
}