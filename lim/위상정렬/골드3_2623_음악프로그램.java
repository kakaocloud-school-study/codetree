package lim.위상정렬;

import java.util.*;
import java.io.*;

public class 골드3_2623_음악프로그램 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m;
    static int[] inDegrees;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    static void sol() throws IOException {
        LinkedList<Integer> queue = new LinkedList<>();
        for (int node = 1; node < inDegrees.length; node++) {
            if (inDegrees[node] == 0) {
                queue.offer(node);
            }
        }

        ArrayList<Integer> arr = new ArrayList<>();
        while (!queue.isEmpty()) {
            int node = queue.poll();
            arr.add(node);
            for (int nextNode : graph.get(node)) {
                inDegrees[nextNode]--;
                if (inDegrees[nextNode] == 0) {
                    queue.offer(nextNode);
                }
            }
        }

        if (arr.size() != n) {
            bw.write("0");
            return;
        }

        for (int num : arr) {
            bw.write(num + "\n");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        inDegrees = new int[n + 1];

        for (int i = 0; i < inDegrees.length; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken());

            int prevNode = -1;
            for (int j = 0; j < count; j++) {
                int node = Integer.parseInt(st.nextToken());
                if (prevNode != -1) {
                    graph.get(prevNode).add(node);
                    inDegrees[node]++;
                }
                prevNode = node;
            }
        }

        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}