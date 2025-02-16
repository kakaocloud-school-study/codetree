package lim.백트래킹;

import java.util.*;
import java.io.*;

public class 골드4_5639_이진_검색_트리 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] arr;

    static void func(int sIdx, int eIdx) throws IOException {
        if (sIdx == eIdx) {
            bw.write(arr[sIdx] + "\n");
            return;
        }
        int rootIdx = sIdx;
        int leftSIdx = eIdx + 1;
        int rightSIdx = eIdx + 1;
        if (arr[rootIdx + 1] < arr[rootIdx]) {
            leftSIdx = rootIdx + 1;
        }
        for (int i = rootIdx + 1; i < arr.length; i++) {
            if (arr[i] > arr[rootIdx]) {
                rightSIdx = i;
                break;
            }
        }
        if (leftSIdx != eIdx + 1) {
            func(leftSIdx, rightSIdx - 1);
        }
        if (rightSIdx != eIdx + 1) {
            func(rightSIdx, eIdx);
        }
        bw.write(arr[rootIdx] + "\n");
    }

    static void sol() throws IOException {
        func(0, arr.length - 1);
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> nums = new ArrayList<>();
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            nums.add(Integer.parseInt(line));
        }

        arr = new int[nums.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = nums.get(i);
        }
        sol();
        sc.close();
        bw.flush();
        bw.close();
    }
}
