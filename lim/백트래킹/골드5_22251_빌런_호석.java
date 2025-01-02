package lim.백트래킹;

import java.util.*;
import java.io.*;

public class 골드5_22251_빌런_호석 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int maxFloor, displaySize, maxFlipCount, realFloor;
    /*
     * 0
     * 1 2
     * 3
     * 4 5
     * 6
     */
    static int[] digitMasks = new int[] {
            0b1110111,
            0b0010010,
            0b1011101,
            0b1011011,
            0b0111010,
            0b1101011,
            0b1101111,
            0b1010010,
            0b1111111,
            0b1111011,
    };

    static void copyToDisplayArr(int num, int[] displayArr) {
        int pos = displayArr.length - 1;
        while (num > 0) {
            int numAtPos = num % 10;
            displayArr[pos] = numAtPos;
            num /= 10;
            pos -= 1;
        }
    }

    static int calMaskDiff(int mask1, int mask2) {
        int xorMask = mask1 ^ mask2;
        int count = 0;
        while (xorMask > 0) {
            count += xorMask & 1;
            xorMask >>= 1;
        }
        return count;
    }

    static int func(int currNum, int currFlipCount, int pos, int[] realDigits) {
        if (pos == realDigits.length) {
            if (currNum <= maxFloor && currNum > 0 && currFlipCount > 0) {
                return 1;
            }
            return 0;
        }

        int count = 0;
        for (int digit = 0; digit < 10; digit++) {
            int realDigit = realDigits[pos];
            int diff = calMaskDiff(digitMasks[digit], digitMasks[realDigit]);
            if (currFlipCount + diff <= maxFlipCount) {
                count += func(currNum * 10 + digit, currFlipCount + diff, pos + 1, realDigits);
            }
        }
        return count;
    }

    static void sol() throws IOException {
        int[] realDigits = new int[displaySize];
        copyToDisplayArr(realFloor, realDigits);
        bw.write(func(0, 0, 0, realDigits) + "");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        maxFloor = Integer.parseInt(st.nextToken());
        displaySize = Integer.parseInt(st.nextToken());
        maxFlipCount = Integer.parseInt(st.nextToken());
        realFloor = Integer.parseInt(st.nextToken());
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}
