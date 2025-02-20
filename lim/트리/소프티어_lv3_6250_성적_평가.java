package lim.트리;

import java.io.*;
import java.util.*;

public class 소프티어_lv3_6250_성적_평가 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] scoresByGameId;

    static int getRank(ArrayList<Integer> sortedScores, int targetScore) {
        int lo = 0, hi = sortedScores.size();
        int higherCount = hi;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            int score = sortedScores.get(mid);
            if (score <= targetScore) {
                hi = mid - 1;
                higherCount = mid;
            } else {
                lo = mid + 1;
            }
        }
        return higherCount + 1;
    }

    static ArrayList<Integer> getRanks(int[] scores) {
        ArrayList<Integer> sortedScores = new ArrayList<>();
        for (int score : scores) {
            sortedScores.add(score);
        }
        Collections.sort(sortedScores, Collections.reverseOrder());

        ArrayList<Integer> ranks = new ArrayList<>();
        for (int i = 0; i < scores.length; i++) {
            int rank = getRank(sortedScores, scores[i]);
            ranks.add(rank);
        }

        return ranks;
    }

    static void sol() throws IOException {
        for (int gameId = 0; gameId < scoresByGameId.length; gameId++) {
            ArrayList<Integer> ranks = getRanks(scoresByGameId[gameId]);
            for (int rank : ranks) {
                bw.write(rank + " ");
            }
            bw.write("\n");
        }

        int[] totalScores = new int[scoresByGameId[0].length];
        for (int i = 0; i < totalScores.length; i++) {
            for (int j = 0; j < scoresByGameId.length; j++) {
                totalScores[i] += scoresByGameId[j][i];
            }
        }
        ArrayList<Integer> ranks = getRanks(totalScores);
        for (int rank : ranks) {
            bw.write(rank + " ");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        scoresByGameId = new int[3][n];

        for (int i = 0; i < scoresByGameId.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < scoresByGameId[0].length; j++) {
                scoresByGameId[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        sol();

        br.close();
        bw.flush();
        bw.close();
    }
}
