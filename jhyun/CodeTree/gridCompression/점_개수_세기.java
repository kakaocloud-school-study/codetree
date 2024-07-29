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

        //예외를 처리하기 위해 최댓값보다 큰 값을 treeset에 넣기
        nums.add((int) (1e9 + 1));

        //treeset에서 정점을 작은 번호부터 뽑으면서 각 정점별로 1번부터 순서대로 매칭하여 map에 넣기
        int cnt = 1;
        for (Integer num : nums) {
            map.put(num, cnt++);
        }

        //질의에 대해 각 [a,b]에 해당하는 번호를 map을 통해 구해 두 번호 사이의 점의 수 출력
        for (int i = 0; i < q; i++) {
            int a = queries[i].a;
            int b = queries[i].b;

            //a보다 크거나 같은 가장 작은 번호를 찾아(없다면, 가장 큰 값 반환) newA에 할당
            int newA = map.get(nums.ceiling(a));
            //b보다 큰 가장 작은 번호를 찾아(없다면, null 반환) newB에 할당
            int newB = map.get(nums.higher(b));

            System.out.println(newB - newA);
        }
    }
}