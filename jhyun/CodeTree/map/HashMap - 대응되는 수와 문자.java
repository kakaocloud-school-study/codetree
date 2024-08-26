import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_N = 100000;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String[] words = new String[MAX_N + 1];
        Map<String, Integer> map = new HashMap<>();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            words[i] = str;
            map.put(str, i);
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            String key = st.nextToken();
            if ('0' <= key.charAt(0) && key.charAt(0) <= '9') {
                System.out.println(words[Integer.parseInt(key)]);
            } else {
                System.out.println(map.get(key));
            }
        }
    }
}