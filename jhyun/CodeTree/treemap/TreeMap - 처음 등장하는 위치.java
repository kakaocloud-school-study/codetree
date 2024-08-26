import java.util.*;
import java.util.Map.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Map<Integer, Integer> map = new TreeMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            int value = Integer.parseInt(st.nextToken());
            if (!map.containsKey(value)) {
                map.put(value, i);
            }
        }

        Iterator<Entry<Integer, Integer>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Entry<Integer, Integer> entry = it.next();
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}