import java.util.*;
import java.io.*;


class Pair {
    int a, b;

    public Pair(int a, int b) {
        this.a = a;
        this.b = b;
    }
}

public class Main {
    static final int MAX_NUM = 100000;
    static int[] arr = new int[MAX_NUM];
    static Pair[] queries = new Pair[MAX_NUM];

    static TreeSet<Integer> nums = new TreeSet<>();
    static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
        }

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            queries[i] = new Pair(a, b);
        }

        for (int i = 0; i < n; i++) {
            nums.add(arr[i]);
        }

        //treeSet에서 정점을 작은 번호부터 뽑으면서 각 정점별로 1번부터 순서대로 매칭하여 map에 넣기
        // -3 -> 1, 5 -> 2, 9 -> 3
        int cnt = 1;
        for (Integer num : nums) {
            map.put(num, cnt++);
        }

        //질의에 대해 각 [a,b]에 해당하는 번호를 map을 통해 구해 두 번호 사이의 점의 수 출력
        for (int i = 0; i < q; i++) {
            int a = queries[i].a;
            int b = queries[i].b;

            int newA = map.get(a);
            int newB = map.get(b);

            System.out.println(newB - newA + 1);
        }
    }
}