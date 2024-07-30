package jhyun.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ20125 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        char[][] arr = new char[num][num];
        for (int i = 0; i < num; i++) {
            String input = br.readLine();
            for (int j = 0; j < num; j++) {
                arr[i][j] = input.charAt(j);
            }
        }

        int x = 0, y = 0;

        for (int i = 0; i < num; i++) {
            boolean check = false;
            for (int j = 0; j < num; j++) {
                if (arr[i][j] == '*') {
                    x = j + 1;
                    y = i + 2;
                    check = true;
                    break;
                }
            }
            if (check) {
                break;
            }
        }
        result(x, arr, y, num);
    }

    private static void result(int x, char[][] arr, int y, int num) {
        int[] size = new int[5];
        for (int i = 0; i < x - 1; i++) {
            if (arr[y - 1][i] == '*') {
                size[0]++;
            }
        }

        for (int i = x; i < num; i++) {
            if (arr[y - 1][i] == '*') {
                size[1]++;
            }
        }

        for (int i = y; i < num; i++) {
            if (arr[i][x - 1] == '*')  {
                size[2]++;
            }
        }

        for (int i = y; i < num; i++) {
            if (arr[i][x - 2]  == '*')  {
                size[3]++;
            }
        }

        for (int i = y; i < num; i++) {
            if (arr[i][x]  == '*'){
                size[4]++;
            }
        }
        System.out.println(y + " " + x);
        System.out.println(size[0] + " " + size[1] + " " + size[2] + " " + size[3] + " " + size[4]);
    }
}
