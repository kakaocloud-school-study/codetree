import java.util.*;
import java.io.*;

public class Main {
    static final int MAX_N = 100000;

    static int n, m;
    static int[] arr = new int[MAX_N];
    static HashMap<Integer, Integer> freq = new HashMap<>();

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        for(int i = 0; i < n; i++) {
            if(!freq.containsKey(arr[i])){
                freq.put(arr[i], 1);
            }
            else {
                freq.put(arr[i], freq.get(arr[i]) + 1);
            }
        }

        for(int i = 0; i < m; i++) {
            int num = sc.nextInt();

            if(!freq.containsKey(num)){
                System.out.print(0 + " ");
            }
            else {
                System.out.print(freq.get(num) + " ");
            }
        }
    }
}