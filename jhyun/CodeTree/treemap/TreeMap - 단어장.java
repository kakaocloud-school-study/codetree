import java.util.*;
import java.io.*;
import java.util.Map.*;

public class Main {
    public static final int MAX_N = 100000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Map<String, Integer> map = new TreeMap<>();
        String[] words = new String[MAX_N];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            words[i] = st.nextToken();
        }

        for (int i = 0; i < n; i++) {
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
        }

        Iterator<Entry<String, Integer>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Entry<String, Integer> entry = it.next();
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}