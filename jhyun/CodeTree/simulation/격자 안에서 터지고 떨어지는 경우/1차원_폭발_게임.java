import java.util.*;
import java.io.*;

public class Main {
    static final int MAX_N = 100;

    static int n, m, endOfArray, endOfTemp;
    static int[] nums = new int[MAX_N];
    static int[] temp = new int[MAX_N];

    //주어진 시작점에 대하여 부분 수열의 끝 위치를 반환
    static int getEndIdxOfExplosion(int start, int curr) {
        int endIdx = start + 1;
        while (endIdx < endOfArray) {
            if (nums[endIdx] == curr) {
                endIdx++;
            } else {
                break;
            }
        }

        return endIdx - 1;
    }

    //터져야 할 폭탄들에 대해 터졌다는 의미로 0을 채우기
    static void fillZero(int start, int end) {
        for (int i = start; i <= end; i++) {
            nums[i] = 0;
        }
    }

    //Arr에서 폭탄이 터진 이후의 결과를 Temp에 임시 저장
    static void moveToTemp() {
        endOfTemp = 0;
        for (int i = 0; i < endOfArray; i++) {
            if (nums[i] != 0) {
                temp[endOfTemp++] = nums[i];
            }
        }
    }

    static void copy() {
        endOfArray = endOfTemp;
        for (int i = 0; i < endOfArray; i++) {
            nums[i] = temp[i];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        endOfArray = n;

        boolean visit;
        do {
            visit = false;
            for (int currIdx = 0; currIdx < endOfArray; currIdx++) {
                //각 위치마다 그 뒤로 폭탄이 m개 이상 있는지 확인
                //이미 터지기로 예정되어 있는 폭탄은 패스
                if (nums[currIdx] == 0) {
                    continue;
                }

                //currIdx로부터 연속하여 같은 숫자를 갖는 폭탄 중 가장 마지막 위치를 찾아 반환
                int endIdx = getEndIdxOfExplosion(currIdx, nums[currIdx]);

                if (endIdx - currIdx + 1 >= m) {
                    //연속한 숫자의 개수가 m개 이상인 경우 폭탄이 터졌음을 기록
                    fillZero(currIdx, endIdx);
                    visit = true;
                }
            }

            //Arr에서 폭탄이 터진 이후의 결과를 Temp에 임시 저장
            moveToTemp();
            //Temp배열에 그대로 Copy하여 Arr에 저장
            copy();
        } while (visit); // 더 이상 폭탄이 터질 수 없을 때까지 반복

        System.out.println(endOfArray);
        for (int i = 0; i < endOfArray; i++) {
            System.out.println(nums[i]);
        }
    }
}