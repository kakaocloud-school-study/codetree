package lim.set;

import java.util.*;
import java.io.*;

public class HashSet_초대장과_번호표 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m;
    static ArrayList<HashSet<Integer>> groups = new ArrayList<>();

    static void sol() throws IOException {
        int count = 1;
        LinkedList<Integer> queue = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        queue.offer(1);
        visited.add(1);
        while (!queue.isEmpty()) {
            int num = queue.poll();
            ArrayList<HashSet<Integer>> newGroups = new ArrayList<>();
            for (HashSet<Integer> group : groups) {
                if (group.contains(num)) {
                    group.remove(num);
                }
                if (group.size() == 1) {
                    int nNum = group.iterator().next();
                    if (visited.contains(nNum)) {
                        continue;
                    }
                    queue.offer(nNum);
                    visited.add(nNum);
                    count++;
                } else if (group.size() > 1) {
                    newGroups.add(group);
                }
            }
            groups = newGroups;
        }
        bw.write(count + "");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int memberCount = Integer.parseInt(st.nextToken());
            HashSet<Integer> group = new HashSet<>();
            for (int j = 0; j < memberCount; j++) {
                int num = Integer.parseInt(st.nextToken());
                group.add(num);
            }
            groups.add(group);
        }
        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}