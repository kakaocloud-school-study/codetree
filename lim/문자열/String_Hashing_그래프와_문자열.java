/*
 * 1에서 모든 노드를 탐색 가능하고 간선이 n-1개라서 최소 스패닝으로 연결된 트리임을 알 수 있음
 * -> 트리이므로 완전 탐색하면 모든 경로 파악 가능
 * 재귀로 탐색해가면서 패턴 크기의 해시를 슬라이딩 윈도우해가며 해시패턴 일치 여부를 체크하며 진행하면 됨
 */
package lim.문자열;

import java.util.*;
import java.io.*;

public class String_Hashing_그래프와_문자열 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static String pattern;
    static final int P_NUM = 31, M_NUM = 1_000_000_007;
    static int n, l, answer = 0;
    static long pHash;
    static long[] pPow;
    static HashMap<Integer, HashMap<Integer, Integer>> graph = new HashMap<>();

    static void dfs(int node, int idx, long wHash, LinkedList<Integer> arr) {
        if (idx == l && wHash == pHash) {
            answer++;
        }
        for (Map.Entry<Integer, Integer> e : graph.get(node).entrySet()) {
            int nextNode = e.getKey();
            int ch = e.getValue();
            if (idx == l) {
                int frontCh = arr.pollFirst();
                long newWHash = wHash - ((frontCh * pPow[l - 1]) % M_NUM);
                if (newWHash < 0) {
                    newWHash += M_NUM;
                }
                newWHash *= P_NUM;
                newWHash %= M_NUM;
                newWHash += ch;
                newWHash %= M_NUM;

                arr.offerLast(ch);
                dfs(nextNode, idx, newWHash, arr);

                arr.pollLast();
                arr.offerFirst(frontCh);
            } else {
                long newWHash = wHash + ((ch * pPow[l - 1 - idx]) % M_NUM);
                newWHash %= M_NUM;

                arr.offerLast(ch);
                dfs(nextNode, idx + 1, newWHash, arr);

                arr.pollLast();
            }
        }
    }

    static void sol() throws IOException {
        pPow = new long[pattern.length()];
        pPow[0] = 1;
        for (int i = 1; i < pPow.length; i++) {
            pPow[i] = (pPow[i - 1] * P_NUM) % M_NUM;
        }

        for (int i = 0; i < pattern.length(); i++) {
            long ch = pattern.charAt(i) - 'a' + 1;
            pHash += ch * pPow[pattern.length() - i - 1];
            pHash %= M_NUM;
        }

        dfs(1, 0, 0, new LinkedList<>());

        bw.write(answer + "");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        pattern = st.nextToken();
        l = pattern.length();

        for (int i = 1; i < n + 1; i++) {
            graph.put(i, new HashMap<>());
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            char ch = st.nextToken().charAt(0);
            graph.get(s).put(e, ch - 'a' + 1);
        }

        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}
