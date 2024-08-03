package jhyun.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ9017 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for (int t = 0; t < testCase; t++) {
            int n = Integer.parseInt(br.readLine());
            int[] ranks = new int[n];
            Map<Integer, Integer> teamCount = new HashMap<>();

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                ranks[i] = Integer.parseInt(st.nextToken());
                teamCount.put(ranks[i], teamCount.getOrDefault(ranks[i], 0) + 1);
            }

            Map<Integer, List<Integer>> teamScores = new HashMap<>();
            int score = 1;

            for (int team : ranks) {
                if (teamCount.get(team) == 6) {
                    teamScores.putIfAbsent(team, new ArrayList<>());
                    if (teamScores.get(team).size() < 6) {
                        teamScores.get(team).add(score);
                    }
                    score++;
                }
            }

            int winnerTeam = 0;
            int minScore = Integer.MAX_VALUE;
            int minFifthScore = Integer.MAX_VALUE;

            for (Map.Entry<Integer, List<Integer>> entry : teamScores.entrySet()) {
                int team = entry.getKey();
                List<Integer> scores = entry.getValue();

                if (scores.size() < 6) continue;

                int teamScore = scores.get(0) + scores.get(1) + scores.get(2) + scores.get(3);
                int fifthScore = scores.get(4);

                if (teamScore < minScore || (teamScore == minScore && fifthScore < minFifthScore)) {
                    winnerTeam = team;
                    minScore = teamScore;
                    minFifthScore = fifthScore;
                }
            }

            System.out.println(winnerTeam);
        }
    }
}