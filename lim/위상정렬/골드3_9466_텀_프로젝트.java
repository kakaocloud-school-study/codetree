/*
 * 위상정렬로 풀었지만 다른 풀이들은 DFS 변형으로 풀었음
 */
package lim.위상정렬;

import java.util.*;
import java.io.*;

public class 골드3_9466_텀_프로젝트 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] inDegrees;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    static void sol() throws IOException {
        int count = 0;
        LinkedList<Integer> queue = new LinkedList<>();
        for (int node = 1; node < inDegrees.length; node++) {
            if (inDegrees[node] == 0) {
                queue.offer(node);
            }
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();
            count++;
            for (int nextNode : graph.get(node)) {
                inDegrees[nextNode]--;
                if (inDegrees[nextNode] == 0) {
                    queue.offer(nextNode);
                }
            }
        }

        bw.write(count + "\n");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        for (int unused = 0; unused < t; unused++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            inDegrees = new int[n + 1];

            graph.clear();
            for (int i = 0; i < inDegrees.length; i++) {
                graph.add(new ArrayList<>());
            }

            st = new StringTokenizer(br.readLine());
            for (int node = 1; node < inDegrees.length; node++) {
                int nextNode = Integer.parseInt(st.nextToken());
                graph.get(node).add(nextNode);
                inDegrees[nextNode]++;
            }

            sol();
        }

        br.close();
        bw.flush();
        bw.close();
    }
}