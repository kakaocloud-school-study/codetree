package lim.백트래킹;

import java.io.*;
import java.util.*;

public class 소프티어_lv3_6251_업무_처리 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int height, days;
    static ArrayList<Node> leafNodes = new ArrayList<>();
    static ArrayList<LinkedList<Integer>> tasksByNode = new ArrayList<>();

    static class Node {
        Node left, right;
        LinkedList<Integer> tasks = new LinkedList<>();
    }

    static Node createNodes(int depth) {
        Node node = new Node();
        if (depth == height) {
            leafNodes.add(node);
            return node;
        }
        node.left = createNodes(depth + 1);
        node.right = createNodes(depth + 1);
        return node;
    }

    static void moveTask(Node parent, Node child) {
        if (parent == null || child == null) {
            return;
        }
        if (!child.tasks.isEmpty()) {
            parent.tasks.offer(child.tasks.poll());
        }
    }

    static void upTasks(int day, Node node) {
        if (node == null) {
            return;
        }

        if (day % 2 == 1) {
            moveTask(node, node.left);
        } else {
            moveTask(node, node.right);
        }
        upTasks(day, node.left);
        upTasks(day, node.right);
    }

    static void sol() throws IOException {
        Node root = createNodes(0);
        for (int i = 0; i < leafNodes.size(); i++) {
            leafNodes.get(i).tasks = tasksByNode.get(i);
        }

        for (int day = 2; day <= days; day++) {
            upTasks(day, root);
        }

        bw.write(root.tasks.stream().reduce((it1, it2) -> it1 + it2).orElse(0).toString());
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        height = Integer.parseInt(st.nextToken());
        int taskCount = Integer.parseInt(st.nextToken());
        days = Integer.parseInt(st.nextToken());
        int leafCount = 1 << height;

        while (leafCount-- > 0) {
            st = new StringTokenizer(br.readLine());
            LinkedList<Integer> tasks = new LinkedList<>();
            for (int i = 0; i < taskCount; i++) {
                tasks.add(Integer.parseInt(st.nextToken()));
            }
            tasksByNode.add(tasks);
        }

        sol();

        br.close();
        bw.flush();
        bw.close();
    }
}
