package lim.트리;

import java.util.*;
import java.io.*;

public class 이진_트리와_탐색_순회법_변경_2 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] inorder, preorder;

    static void func(int preS, int preE, int inS, int inE) throws IOException {
        if (preE < preS) {
            return;
        }
        int root = preorder[preS];
        int rootIdxInInorder = 0;
        for (int i = inS; i <= inE; i++) {
            if (root == inorder[i]) {
                rootIdxInInorder = i;
                break;
            }
        }

        int rightLenInInorder = inE - rootIdxInInorder;
        int leftLenInInorder = inE - inS - rightLenInInorder;
        func(preS + 1, preS + leftLenInInorder, inS, rootIdxInInorder - 1);
        func(preE - rightLenInInorder + 1, preE, rootIdxInInorder + 1, inE);
        bw.write(root + " ");
    }

    static void sol() throws IOException {
        func(0, preorder.length - 1, 0, preorder.length - 1);
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        preorder = new int[n];
        inorder = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            preorder[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            inorder[i] = Integer.parseInt(st.nextToken());
        }

        sol();
        br.close();
    }
}
