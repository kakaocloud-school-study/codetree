import java.util.*;
import java.io.*;

public class Main {
    static final int MAX_N = 100;

    static int n;
    static int[] nums = new int[MAX_N];
    static int endOfArray;

    static void cutArray(int start, int end) {
        int[] temp = new int[MAX_N];
        int endOfTemp = 0;

        for (int i = 0; i < endOfArray; i++) {
            if (i < start || i > end) {
                temp[endOfTemp++] = nums[i];
            }
        }

        for (int i = 0; i < endOfTemp; i++) {
            nums[i] = temp[i];
        }

        endOfArray = endOfTemp;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }
        endOfArray = n;

        for (int k = 0; k < 2; k++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            s--;
            e--;
            cutArray(s, e);
        }

        System.out.println(endOfArray);
        for (int i = 0; i < endOfArray; i++) {
            System.out.println(nums[i]);
        }
    }
}