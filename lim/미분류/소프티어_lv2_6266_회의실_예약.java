package lim.미분류;

import java.io.*;
import java.util.*;

public class 소프티어_lv2_6266_회의실_예약 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static HashMap<String, ArrayList<Segment>> segsByName = new HashMap<>();

    static class Segment implements Comparable<Segment> {
        int s, e;
        String name;

        public Segment(int s, int e, String name) {
            this.s = s;
            this.e = e;
            this.name = name;
        }

        @Override
        public int compareTo(Segment o) {
            return this.s - o.s;
        }
    }

    static void mergeSegs(ArrayList<Segment> segs) {
        ArrayList<Segment> newSegs = new ArrayList<>();

        Segment prevSeg = null;
        for (Segment seg : segs) {
            if (prevSeg == null) {
                prevSeg = seg;
                continue;
            }

            if (prevSeg.e == seg.s) {
                prevSeg.e = seg.e;
            } else {
                newSegs.add(prevSeg);
                prevSeg = seg;
            }
        }
    }

    static ArrayList<Segment> getEmptySegs(String name) {
        ArrayList<Segment> segs = segsByName.get(name);
        mergeSegs(segs);

        ArrayList<Segment> emptySegs = new ArrayList<>();
        int prevE = 9;
        for (Segment seg : segs) {
            if (prevE < seg.s) {
                emptySegs.add(new Segment(prevE, seg.s, name));
            }
            prevE = seg.e;
        }
        if (prevE < 18) {
            emptySegs.add(new Segment(prevE, 18, name));
        }
        return emptySegs;
    }

    static void sol() throws IOException {
        ArrayList<String> names = new ArrayList<>(segsByName.keySet());
        Collections.sort(names);

        ArrayList<String> outputs = new ArrayList<>();
        for (String name : names) {
            ArrayList<Segment> emptySegs = getEmptySegs(name);
            String output = String.format("Room %s:\n", name);
            output += String.format("%s\n", emptySegs.isEmpty() ? "Not available" : emptySegs.size() + " available:");
            for (Segment seg : emptySegs) {
                output += String.format("%02d-%02d\n", seg.s, seg.e);
            }
            outputs.add(output);
        }
        bw.write(String.join("-----\n", outputs));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            segsByName.put(br.readLine(), new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            segsByName.get(name).add(new Segment(s, e, name));
        }
        for (ArrayList<Segment> segs : segsByName.values()) {
            Collections.sort(segs);
        }

        sol();

        br.close();
        bw.flush();
        bw.close();
    }
}
