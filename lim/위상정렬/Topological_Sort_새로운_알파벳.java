/*
 * 주어진 단어들에서 인접 두단어의 같은 자리 문자들을 쭉 스캔하며 간선을 도출할 수 있다
 * 사전순 우선순위를 도출해야 하므로 1자 그래프 모양이 유일하게 나와야 한다 
 */
package lim.위상정렬;

import java.util.*;
import java.io.*;

public class Topological_Sort_새로운_알파벳 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static HashMap<Character, ArrayList<Character>> graph = new HashMap<>();
    static HashMap<Character, Integer> inDegrees = new HashMap<>();
    static LinkedList<Character> queue = new LinkedList<>();
    static String[] words;
    static HashSet<Character> chars = new HashSet<>();
    static HashSet<Character> comparedChars = new HashSet<>();
    static int n, m;

    static void scanWord(String prevWord, String word) {
        for (int i = 0; i < word.length() && i < prevWord.length(); i++) {
            char prevChar = prevWord.charAt(i);
            char nextChar = word.charAt(i);
            if (prevChar != nextChar) {
                graph.get(prevChar).add(nextChar);
                inDegrees.put(nextChar, inDegrees.get(nextChar) + 1);
                comparedChars.add(prevChar);
                comparedChars.add(nextChar);
                return;
            }
        }
    }

    static void sol() throws IOException {
        if (chars.size() == 1) {
            bw.write(chars.iterator().next());
            return;
        }
        ArrayList<Character> tSorted = new ArrayList<>();
        String prevWord = words[0];
        for (int i = 1; i < words.length; i++) {
            scanWord(prevWord, words[i]);
            prevWord = words[i];
        }

        if (comparedChars.size() != chars.size()) {
            bw.write("inf");
            return;
        }

        for (Map.Entry<Character, Integer> e : inDegrees.entrySet()) {
            char ch = e.getKey();
            int inDegree = e.getValue();
            if (inDegree == 0) {
                queue.offer(ch);
                tSorted.add(ch);
            }
        }

        if (tSorted.size() > 1) {
            bw.write("inf");
            return;
        }

        HashSet<Character> popped = new HashSet<>();
        popped.addAll(queue);
        while (!queue.isEmpty()) {
            char node = queue.poll();

            int directCount = 0;
            for (char nextNode : graph.get(node)) {
                if (popped.contains(nextNode)) {
                    continue;
                }
                int newChildDegree = inDegrees.get(nextNode) - 1;
                inDegrees.put(nextNode, newChildDegree);
                if (newChildDegree == 0) {
                    queue.offer(nextNode);
                    popped.add(nextNode);
                    tSorted.add(nextNode);
                    directCount++;
                }
                if (directCount > 1) { // 사전순은 1차원이므로 직접 연결되는 노드가 하나여야 함
                    bw.write("inf");
                    return;
                }
            }
        }

        if (tSorted.size() != chars.size()) {
            bw.write("-1");
            return;
        }

        for (char ch : tSorted) {
            bw.write(ch);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = br.readLine();
            for (char ch : words[i].toCharArray()) {
                chars.add(ch);
            }
        }

        for (char ch : chars) {
            graph.put(ch, new ArrayList<>());
            inDegrees.put(ch, 0);
        }

        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}