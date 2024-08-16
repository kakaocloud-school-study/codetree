package lim.위상정렬;

import java.util.*;
import java.io.*;

public class Topological_Sort_조립_2 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static HashSet<Integer> visited = new HashSet<>();
    static HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
    static HashMap<Integer, Integer> inDegrees = new HashMap<>();
    static LinkedList<Integer> queue = new LinkedList<>();
    static int n, m;

    static void sol() throws IOException {
        HashSet<Integer> popped = new HashSet<>();
        popped.addAll(queue);
        while (!queue.isEmpty()) {
            Integer node = queue.poll();
            if (graph.get(node) == null) {
                continue;
            }
            for (Integer nextNode : graph.get(node)) {
                if (popped.contains(nextNode)) {
                    continue;
                }
                int newChildDegree = inDegrees.get(nextNode) - 1;
                inDegrees.put(nextNode, newChildDegree);
                if (newChildDegree == 0) {
                    queue.offer(nextNode);
                    popped.add(nextNode);
                }
            }
        }

        ArrayList<Integer> history = new ArrayList<>();
        history.addAll(popped);
        history.sort(Comparator.naturalOrder());
        bw.write(history.size() + "\n");
        for (Integer node : history) {
            bw.write(node + " ");
        }

        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < m; i++) {
            String[] arr = br.readLine().split(" ");
            int target = Integer.parseInt(arr[0]);
            int inDegree = Integer.parseInt(arr[1]);
            arr = br.readLine().split(" ");
            for (String word : arr) {
                int currNode = Integer.parseInt(word);
                if (graph.get(currNode) == null) {
                    graph.put(currNode, new ArrayList<>());
                }
                graph.get(currNode).add(target);
            }
            inDegrees.put(target, inDegrees.getOrDefault(target, 0) + inDegree);
        }

        br.readLine();
        String[] startNodes = br.readLine().split(" ");
        for (String node : startNodes) {
            queue.offer(Integer.parseInt(node));
        }

        sol();
        br.close();
    }
}