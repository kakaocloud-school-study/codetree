/*
 * 14퍼센트에서 실패 -> Long.MAX_VALUE이라 해야하는데  Integer.MAX_VALUE로 함...
 */
package lim.미분류;

import java.util.*;
import java.io.*;

public class 횡단보도_골드1_24042 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m;
    static long[] minDist;
    static HashSet<Integer> visited = new HashSet<>();
    static ArrayList<ArrayList<ArrayList<Integer>>> graph = new ArrayList<>();

    static class Item {
        int node;
        long totalTime;

        Item(int node, long totalTime) {
            this.node = node;
            this.totalTime = totalTime;
        }
    }

    static void sol() throws IOException {
        PriorityQueue<Item> queue = new PriorityQueue<>((it1, it2) -> {
            if (it1.totalTime == it2.totalTime) {
                return it1.node - it2.node;
            }

            if (it1.totalTime < it2.totalTime) {
                return -1;
            } else if (it1.totalTime > it2.totalTime) {
                return 1;
            }
            return 0;
        });
        queue.offer(new Item(1, 0));
        while (!queue.isEmpty()) {
            Item item = queue.poll();
            if (item.totalTime > minDist[item.node]) {
                continue;
            }

            for (ArrayList<Integer> dest : graph.get(item.node)) {
                int nNode = dest.get(0);
                long cost = dest.get(1);
                long timeDiff = cost - item.totalTime % m;
                if (timeDiff < 0) {
                    timeDiff += m;
                }
                long newTotalTime = item.totalTime + timeDiff;
                if (minDist[nNode] > newTotalTime) {
                    queue.add(new Item(nNode, newTotalTime));
                    minDist[nNode] = newTotalTime;
                }
            }
        }

        bw.write(String.valueOf(minDist[n]));
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        minDist = new long[n + 1];
        for (int i = 0; i <= n; i++) {
            minDist[i] = Long.MAX_VALUE;
        }
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            ArrayList<Integer> dest = new ArrayList<>();
            dest.add(e);
            dest.add(i);
            graph.get(s).add(dest);

            dest = new ArrayList<>();
            dest.add(s);
            dest.add(i);
            graph.get(e).add(dest);
        }
        sol();
        br.close();
    }
}