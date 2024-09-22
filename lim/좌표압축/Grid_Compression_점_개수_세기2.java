package lim.좌표압축;

import java.util.*;
import java.io.*;

public class Grid_Compression_점_개수_세기2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, q;
    static TreeMap<Integer, Integer> idxByX = new TreeMap<>(), idxByY = new TreeMap<>();
    static int[][] countGrid, presumGrid;
    static int[][] queries, postions;

    static void sol() throws IOException {
        for (int i = 1; i < countGrid.length; i++) {
            for (int j = 1; j < countGrid[0].length; j++) {
                presumGrid[i][j] = presumGrid[i][j - 1] + countGrid[i][j];
            }
        }
        for (int j = 1; j < countGrid[0].length; j++) {
            for (int i = 1; i < countGrid.length; i++) {
                presumGrid[i][j] += presumGrid[i - 1][j];
            }
        }

        for (int i = 0; i < queries.length; i++) {
            int x1 = queries[i][0], y1 = queries[i][1], x2 = queries[i][2], y2 = queries[i][3];
            int xIdx1 = idxByX.ceilingEntry(x1).getValue(), yIdx1 = idxByY.ceilingEntry(y1).getValue(),
                    xIdx2 = idxByX.floorEntry(x2).getValue(), yIdx2 = idxByY.floorEntry(y2).getValue();
            int value = 0;
            value += presumGrid[xIdx2][yIdx2];
            value -= presumGrid[xIdx2][yIdx1 - 1];
            value -= presumGrid[xIdx1 - 1][yIdx2];
            value += presumGrid[xIdx1 - 1][yIdx1 - 1];
            bw.write(value + "\n");
        }
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        postions = new int[n][2];
        for (int i = 0; i < postions.length; i++) {
            st = new StringTokenizer(br.readLine());
            postions[i][0] = Integer.parseInt(st.nextToken());
            postions[i][1] = Integer.parseInt(st.nextToken());
            idxByX.put(postions[i][0], 0);
            idxByY.put(postions[i][1], 0);
        }
        idxByX.put(-1_000_000_000, 0);
        idxByY.put(-1_000_000_000, 0);
        idxByX.put(1_000_000_000, 0);
        idxByY.put(1_000_000_000, 0);

        queries = new int[q][4];
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            queries[i][0] = Integer.parseInt(st.nextToken());
            queries[i][1] = Integer.parseInt(st.nextToken());
            queries[i][2] = Integer.parseInt(st.nextToken());
            queries[i][3] = Integer.parseInt(st.nextToken());
        }

        int idx = 1;
        for (Map.Entry<Integer, Integer> e : idxByX.entrySet()) {
            e.setValue(idx++);
        }
        idx = 1;
        for (Map.Entry<Integer, Integer> e : idxByY.entrySet()) {
            e.setValue(idx++);
        }

        countGrid = new int[idxByX.size() + 1][idxByY.size() + 1];
        presumGrid = new int[idxByX.size() + 1][idxByY.size() + 1];

        for (int i = 0; i < postions.length; i++) {
            int xIdx = idxByX.get(postions[i][0]);
            int yIdx = idxByY.get(postions[i][1]);
            countGrid[xIdx][yIdx] = 1;
        }
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}
