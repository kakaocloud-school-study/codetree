package lim.미분류;

import java.util.*;
import java.io.*;

public class 줄세우기_실버5_10431 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] arr;

    static void sol() throws IOException {
        LinkedList<Integer> line = new LinkedList<>();
        int total = 0;
        for (int student : arr) {
            ListIterator<Integer> it = line.listIterator(0);
            int backStudents = line.size();
            if (line.isEmpty()) {
                line.add(student);
                continue;
            }
            while (it.hasNext()) {
                int currStudent = it.next();
                if (currStudent > student) {
                    it.previous();
                    it.add(student);
                    it.next();
                    break;
                } else if (!it.hasNext()) {
                    it.add(student);
                }
                backStudents--;
            }
            total += backStudents;
        }
        bw.write(total + "\n");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int tNum = Integer.parseInt(st.nextToken());
            arr = new int[20];
            bw.write(tNum + " ");
            for (int j = 0; j < 20; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            sol();
        }

        bw.flush();
        bw.close();
        br.close();
    }
}