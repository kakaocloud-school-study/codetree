import java.util.*;
import java.io.*;


public class Main {
    static String a, b;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        a = br.readLine();
        b = br.readLine();

        //계속 매치 되다가 처음으로 미스매치가 되는 순간을 잡아 횟수 계산
        //그 후 최대 4자리까지만 확인 후 다시 미스매치가 되는 순간 찾기
        int ans = 0;
        boolean mismatched = false;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                //다시 미스매치가 처음으로 발생하는 순간이라면 답을 갱신
                if (!mismatched || cnt >= 4) {
                    mismatched = true;
                    cnt = 1;
                    ans++;
                } else {
                    cnt++;
                }
            } else {
                mismatched = false;
                cnt = 0;
            }
        }
        System.out.print(ans);
    }
}