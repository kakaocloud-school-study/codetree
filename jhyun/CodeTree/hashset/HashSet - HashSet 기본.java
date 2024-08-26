import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Set<Integer> hashSet = new HashSet<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            if (command.equals("add")) {
                hashSet.add(num);
            } else if (command.equals("find")) {
                if (hashSet.contains(num)) {
                    System.out.println("true");
                } else {
                    System.out.println("false");
                }
            } else {
                hashSet.remove(num);
            }
        }
    }
}