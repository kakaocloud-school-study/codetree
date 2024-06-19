import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if (command.equals("push")) {
                pq.add(-Integer.parseInt(st.nextToken()));
            } else if (command.equals("size")) {
                System.out.println(pq.size());
            } else if (command.equals("empty")) {
                if (pq.isEmpty()) {
                    System.out.println("1");
                } else {
                    System.out.println("0");
                }
            } else if (command.equals("pop")) {
                if (!pq.isEmpty()) {
                    System.out.println(-pq.poll());
                }
            } else {
                if (!pq.isEmpty()) {
                    System.out.println(-pq.peek());
                }
            }
        }
    }
}