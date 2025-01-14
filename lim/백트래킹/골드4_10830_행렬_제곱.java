package lim.백트래킹;

import java.util.*;
import java.io.*;

public class 골드4_10830_행렬_제곱 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int[][] multiplyMatrix(int[][] matrix1, int[][] matrix2) {
        int[][] matrix = new int[matrix1.length][matrix2[0].length];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix2[0].length; j++) {
                for (int k = 0; k < matrix1[0].length; k++) {
                    matrix[i][j] += (matrix1[i][k] * matrix2[k][j]);
                    matrix[i][j] %= 1000;
                }
            }
        }
        return matrix;
    }

    static int[][] repeatMatrix(int[][] matrix, long repeat) {
        if (repeat == 1) {
            return matrix;
        }

        long halfRepeat = repeat / 2;
        int[][] halfRepeatedMatrix = repeatMatrix(matrix, halfRepeat);
        if (repeat % 2 == 0) {
            return multiplyMatrix(halfRepeatedMatrix, halfRepeatedMatrix);
        } else {
            return multiplyMatrix(matrix, multiplyMatrix(halfRepeatedMatrix, halfRepeatedMatrix));
        }
    }

    static void sol(int[][] matrix, long repeat) throws IOException {
        int[][] repeatedMatrix = repeatMatrix(matrix, repeat);
        for (int i = 0; i < repeatedMatrix.length; i++) {
            for (int j = 0; j < repeatedMatrix[0].length; j++) {
                bw.write(repeatedMatrix[i][j] % 1000 + " ");
            }
            bw.write("\n");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[][] matrix = new int[n][n];
        long repeat = Long.parseLong(st.nextToken());
        for (int i = 0; i < matrix.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        sol(matrix, repeat);
        br.close();
        bw.flush();
        bw.close();
    }
}
