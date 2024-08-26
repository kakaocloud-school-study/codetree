import java.io.*;

public class Main {
    static final int MAX_N = 200001;

    static String tmp;
    static char[] inputStr = new char[MAX_N];
    static int n;

    static int[] A = new int[MAX_N];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String tmp = br.readLine();
        int len = tmp.length();

        for(int i = 0; i < len; i++){
            inputStr[i * 2] = '#';
            inputStr[i * 2 + 1] = tmp.charAt(i);
        }

        n = len * 2 + 1;
        inputStr[n - 1] = '#';

        int r = -1;
        int p = -1;
        // r : j < i를 만족하는 j들 중 Math.max(j + A[j]) 값을 기록
        // p : Math.max(j + A[j]) 가 되는 j의 값을 기록

        for(int i = 0; i < n; i++){
            // r값이 i보다 같거나 크다면
            // i를 p로부터 대칭시켰을 때의 위치인 ii에 대해
            // 이미 계산된 A[ii]값을 이용하여
            // i를 중심으로 뻗어나갈 수 있는 적절한 초기값을
            // O(1)에 정해줄 수 있습니다.
            if(r < i){
                A[i] = 0;
            } else{
                int ii = 2 * p - i;
                A[i] = Math.min(r-i, A[ii]);
            }

            while(i - A[i] - 1 >= 0 && i + A[i] + 1 < n && inputStr[i - A[i] - 1] == inputStr[i + A[i] + 1])
                A[i]++;

            // i + A[i] 중 최대가 선택되도록
            // r, p값을 갱신해줍니다.
            if(i + A[i] > r) {
                r = i + A[i];
                p = i;
            }
        }

        // 최장 팰린드롬의 길이를 계산합니다.
        int ans = 0;
        for(int i = 0; i < n; i++)
            ans = Math.max(ans, 2 * A[i] + 1);

        // 처음 주어진 문자열에서
        // #을 제외한 부분의 길이가 실제 답이 되기에
        // 2로 나눴을 때의 몫이 답이 됩니다.
        System.out.print(ans / 2);
    }
}