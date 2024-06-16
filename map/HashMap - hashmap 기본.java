import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Map<Integer, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if (command.equals("add")) {
                int key = Integer.parseInt(st.nextToken());
                int value = 이 Integer.parseInt(st.nextToken());
                map.put(key, value);
            } else if (command.equals("find")) {
                int key = Integer.parseInt(st.nextToken());
                if (map.containsKey(key)) {
                    sb.append(map.get(key)).append('\n');
                } else {
                    sb.append("None").append('\n');
                }
            } else if (command.equals("remove")) {
                int key = Integer.parseInt(st.nextToken());
                map.remove(key);
            }
        }
        System.out.println(sb);
    }
}