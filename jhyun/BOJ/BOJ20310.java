package CodingTest.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
import org.w3c.dom.Node;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int num0 = 0;
        int num1 = 0;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            sb.append(c);
            if (c == '0') {
                num0++;
            } else {
                num1++;
            }
        }

        func(num0, num1, sb);

        print(sb);
    }

    static void func(int num0, int num1, StringBuilder sb) {
        num0 /= 2;
        num1 /= 2;

        //앞에서부터 1 없애기
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '1') {
                sb.setCharAt(i, '2');
                num1--;
            }
            if (num1 == 0) {
                break;
            }
        }

        //뒤에서부터 0 없애기
        for(int i = sb.length()-1; i > -1; i--){
            if(sb.charAt(i)=='0') {
                sb.setCharAt(i,'2');
                num0--;
            }
            if(num0 == 0) {
                break;
            }
        }
    }

    static void print(StringBuilder sb) {
        for(int i = 0; i< sb.length(); i++){
            if(sb.charAt(i) == '1' | sb.charAt(i) == '0'){
                System.out.print(sb.charAt(i));
            }
        }
    }
}