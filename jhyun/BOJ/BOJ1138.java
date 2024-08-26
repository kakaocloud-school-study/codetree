package CodingTest.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
import org.w3c.dom.Node;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int [] tall = new int[n+1];
        List<Integer> ans = new ArrayList<>();

        for(int i=1; i<=n; i++) {
            tall[i] = scan.nextInt();
        }

        for(int i=n; i>=1; i--) {
            ans.add(tall[i], i);
        }

        for(int k : ans) {
            System.out.print(k+" ");
        }

    }
}