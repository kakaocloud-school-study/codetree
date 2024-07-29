import java.util.*;
import java.io.*;

class Meeting implements Comparable<Meeting> {
    int s, e;

    public Meeting(int s, int e) {
        this.s = s;
        this.e = e;
    }

    //끝나는 시간 오름차순
    @Override
    public int compareTo(Meeting m) {
        return this.e - m.e;
    }
}

public class Main {
    static int n;
    static List<Meeting> meetings = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            meetings.add(new Meeting(s, e));
        }

        Collections.sort(meetings);

        int ans = 0;
        int lastE = -1; //가장 최근에 잡힌 회의가 끝난 시간
        for (int i = 0; i < n; i++) {
            int s = meetings.get(i).s;
            int e = meetings.get(i).e;

            if (lastE <= s) {
                ans++;
                lastE = e;
            }
        }
        System.out.print(ans);
    }
}