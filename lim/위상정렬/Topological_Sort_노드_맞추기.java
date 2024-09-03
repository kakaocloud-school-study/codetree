package lim.위상정렬;

import java.util.*;
import java.io.*;

public class Topological_Sort_노드_맞추기 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static HashSet<String> visited = new HashSet<>(), roots = new HashSet<>();
    static HashMap<String, ArrayList<String>> graph = new HashMap<>();
    static HashMap<String, ArrayList<String>> tree = new HashMap<>();
    static HashMap<String, Integer> inDegree = new HashMap<>();
    static int n, m;

    static void sol() throws IOException {
        bw.write(roots.size() + "\n");
        ArrayList<String> rootNodes = new ArrayList<>();
        for (String root : roots) {
            rootNodes.add(root);
        }
        rootNodes.sort(Comparator.naturalOrder());
        for (String root : rootNodes) {
            bw.write(root + " ");
        }
        bw.write("\n");

        LinkedList<String> queue = new LinkedList<>();
        queue.addAll(roots);
        while (!queue.isEmpty()) {
            String node = queue.poll();
            ArrayList<String> children = tree.get(node);
            for (String cand : graph.get(node)) {
                int newChildDegree = inDegree.get(cand) - 1;
                inDegree.put(cand, newChildDegree);
                if (newChildDegree == 0) {
                    queue.offer(cand);
                    children.add(cand);
                }
            }
        }

        ArrayList<String> nodes = new ArrayList<>();
        for (String node : graph.keySet()) {
            nodes.add(node);
        }
        nodes.sort(Comparator.naturalOrder());

        for (String node : nodes) {
            bw.write(node + " ");
            bw.write(tree.get(node).size() + " ");
            ArrayList<String> children = tree.get(node);
            children.sort(Comparator.naturalOrder());
            for (String child : children) {
                bw.write(child + " ");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        String[] nodes = br.readLine().split(" ");
        for (String node : nodes) {
            graph.put(node, new ArrayList<>());
            tree.put(node, new ArrayList<>());
            roots.add(node);
        }

        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < m; i++) {
            String[] edge = br.readLine().split(" ");
            String child = edge[0];
            String parent = edge[1];
            graph.get(parent).add(child);
            roots.remove(child);
            int newDegree = inDegree.getOrDefault(child, 0) + 1;
            inDegree.put(child, newDegree);
        }

        sol();
        br.close();
    }
}
