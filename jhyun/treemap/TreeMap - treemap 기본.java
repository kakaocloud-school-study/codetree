import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<Integer, Integer> map = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if (command.equals("add")) {
                int key = Integer.parseInt(st.nextToken());
                int value = Integer.parseInt(st.nextToken());
                map.put(key, value);
            } else if (command.equals("find")) {
                int key = Integer.parseInt(st.nextToken());
                if (map.containsKey(key)) {
                    System.out.println(map.get(key));
                } else {
                    System.out.println("None");
                }
            } else if (command.equals("print_list")) {
                if (map.isEmpty()) {
                    System.out.println("None");
                } else {
                    StringBuilder sb = new StringBuilder();
                    for (Integer value : map.values()) {
                        sb.append(value).append(" ");
                    }
                    System.out.println(sb.toString().trim());
                }
            } else {
                int key = Integer.parseInt(st.nextToken());
                map.remove(key);
            }

        }
    }
}