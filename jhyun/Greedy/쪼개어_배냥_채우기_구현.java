import java.util.*;
import java.io.*;

class Jewel implements Comparable<Jewel> {
    int weight, value;

    public Jewel(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }

    // 가치 / 무게 기준 내림차순
    @Override
    public int compareTo(Jewel j) {
        double x = (double) j.value / j.weight - (double) this.value / this.weight;
        if (x < 0) {
            return -1;
        } else if (x == 0) {
            return 0;
        } else {
            return 1;
        }
    }
}

public class Main {
    static final int MAX_N = 100000;

    static int n, m;
    static List<Jewel> jewels = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            jewels.add(new Jewel(w, v));
        }

        Collections.sort(jewels);

        double ans = 0;
        for (int i = 0; i < n; i++) {
            int w = jewels.get(i).weight;
            int v = jewels.get(i).value;

            if (m >= w) {
                m -= w;
                ans += v;
            } else {
                ans += (double) m / w * v;
                break;
            }
        }
        System.out.printf("%.3f", ans);
    }
}