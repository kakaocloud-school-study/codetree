import java.util.*;
import java.io.*;

public class Main {
    static final int MAX_N = 1000;
    static String a, b;

    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        a = br.readLine();
        b = br.readLine();

        //뒤에서부터 선택 진행
        //현재 위치에 꼭 눌러야만 문제 조건을 만족시킬 수 있다면 눌러주고 넘어감
        int cnt = 0;
        for (int i = n - 1; i >= 0; i--) {
            //두 문자가 다른 경우 & 지금까지 뒤에서 눌렀던 횟수가 짝수번이라 i번째 문자에 영향을 주지 못하는 경우
            //현재 위치를 선택
            if (a.charAt(i) != b.charAt(i) && cnt % 2 == 0) {
                cnt++;
            }

            //두 문자가 같은 경우 & 지금까지 뒤에서 눌렀던 횟수가 홀수번이라 i번째 문자에 영향을 주는 경우
            //현재 위치를 선택
            else if (a.charAt(i) == b.charAt(i) && cnt % 2 == 1) {
                cnt++;
            }
        }
        System.out.print(cnt);
    }
}