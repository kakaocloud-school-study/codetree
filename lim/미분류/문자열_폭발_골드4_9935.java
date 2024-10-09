/*
 * 문제 조건을 잘못봐서 괜히 더 어렵게 풀었음
 * 기본적으로 스택구조를 이용해 한 문자씩 넣어가며 스택 끝에 폭발패턴이 완성될 때마다 패턴을 POP하면 됨
 * 폭발 문자열 길이 제한이 36이므로 매번 패턴 체크해도 무방함
 * 그렇지만, 해당 풀이에서는 원본 문자열과 같은 1,000,000을 상정하고 풀었음
 * 문자열 스택 외에도 폭발 카운트 스택을 둬 매번 패턴을 끝까지 안 보더라도 체크할 수 있도록 함
 */
package lim.미분류;

import java.util.*;
import java.io.*;

public class 문자열_폭발_골드4_9935 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static boolean[] bombed;
    static String word, bombWord;

    static void sol() throws IOException {
        LinkedList<Integer> idxStack = new LinkedList<>();
        LinkedList<Character> stack = new LinkedList<>();

        idxStack.add(-1);
        for (int i = 0; i < word.length(); i++) {
            stack.add(word.charAt(i));
            if (idxStack.getLast() + 1 < bombWord.length()
                    && word.charAt(i) == bombWord.charAt(idxStack.getLast() + 1)) {
                idxStack.add(idxStack.getLast() + 1);
            } else if (word.charAt(i) == bombWord.charAt(0)) {
                idxStack.add(0);
            } else {
                idxStack.add(-1);
            }
            if (idxStack.getLast() + 1 == bombWord.length()) {
                for (int j = 0; j < bombWord.length(); j++) {
                    idxStack.pollLast();
                    stack.pollLast();
                }
            }
        }
        if (stack.size() == 0) {
            bw.write("FRULA");
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (Character ch : stack) {
            sb.append(ch);
        }
        bw.write(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        word = br.readLine();
        bombWord = br.readLine();
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}