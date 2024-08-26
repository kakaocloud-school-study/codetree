import java.util.*;
import java.io.*;

public class Main {
    static class Node{
        String data;
        Node prev, next;

        public Node(String data){
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    public static void connect(Node s, Node e) {
        if(s != null){
            s.next = e;
        }
        if(e != null){
            e.prev = s;
        }
    }

    public static void insertNext(Node target, Node s){
        connect(s, target.next);
        connect(target, s);
    }

    public static void insertPrev(Node target, Node s){
        connect(target.prev, s);
        connect(s, target);
    }

    public static void printNode(Node target){
        String n = "(Null)";

        if(target.prev == null){
            System.out.print(n + " ");
        }
        else{
            System.out.print(target.prev.data + " ");
        }

        System.out.print(target.data + " ");

        if(target.next == null){
            System.out.println(n);
        } else {
            System.out.println(target.next.data);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String sInit = br.readLine();
        Node cur = new Node(sInit);

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());

            //1 S_value : 문자열 S_value를 값으로 가지는 새로운 단일 노드를 생성하고, 이 단일 노드를 노드 cur의 앞에 삽입하세요.
            if(command == 1){
                String data = st.nextToken();
                Node target = new Node(data);

                insertPrev(cur, target);
            }

            //2 S_value : 문자열 S_value를 값으로 가지는 새로운 단일 노드를 생성하고, 이 단일 노드를 노드 cur의 뒤에 삽입하세요.
            if(command == 2){
                String data = st.nextToken();
                Node target = new Node(data);

                insertNext(cur, target);
            }

            //3 : 노드 cur의 이전 노드가 존재한다면, cur를 그 이전 노드로 변경하세요.
            if(command == 3){
                if(cur.prev != null){
                    cur = cur.prev;
                }
            }

            //4 : 노드 cur의 다음 노드가 존재한다면, cur를 그 다음 노드로 변경하세요.
            if(command == 4){
                if(cur.next != null){
                    cur = cur.next;
                }
            }
            printNode(cur);
        }
    }
}