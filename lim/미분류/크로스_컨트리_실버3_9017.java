package lim.미분류;

import java.util.*;
import java.io.*;

public class 크로스_컨트리_실버3_9017 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int[] arr;

    static void sol() throws IOException {
        HashMap<Integer, Integer> countByTeam = new HashMap<>();
        HashMap<Integer, Integer> scoreByTeam = new HashMap<>();
        HashMap<Integer, Integer> fifthScoreByTeam = new HashMap<>();
        HashSet<Integer> failedTeams = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            int team = arr[i];
            int currCount = countByTeam.getOrDefault(team, 0);
            countByTeam.put(team, currCount + 1);
        }
        for (Map.Entry<Integer, Integer> e : countByTeam.entrySet()) {
            int team = e.getKey();
            int count = e.getValue();
            countByTeam.put(team, 0);
            if (count != 6) {
                failedTeams.add(team);
                continue;
            }
        }

        int currScore = 1;
        for (int i = 0; i < arr.length; i++) {
            int team = arr[i];
            if (failedTeams.contains(team)) {
                continue;
            }
            int totalCount = countByTeam.getOrDefault(team, 0);
            int totalScore = scoreByTeam.getOrDefault(team, 0);
            countByTeam.put(team, totalCount + 1);
            if (totalCount + 1 <= 4) {
                scoreByTeam.put(team, totalScore + currScore);
            }
            if (totalCount + 1 == 5) {
                fifthScoreByTeam.put(team, currScore);
            }
            currScore++;
        }

        int winner = 0;
        int minScore = Integer.MAX_VALUE;
        int minFifthInMinScore = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Integer> e : countByTeam.entrySet()) {
            int team = e.getKey();
            int count = e.getValue();
            if (count != 6) {
                continue;
            }
            int score = scoreByTeam.get(team);
            int fifth = fifthScoreByTeam.get(team);
            if (score == minScore) {
                if (fifth < minFifthInMinScore) {
                    minFifthInMinScore = fifth;
                    winner = team;
                }
            } else if (score < minScore) {
                minScore = score;
                minFifthInMinScore = fifth;
                winner = team;
            }
        }

        bw.write(winner + "\n");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());

        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            arr = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            sol();
        }

        bw.flush();
        bw.close();
        br.close();
    }
}