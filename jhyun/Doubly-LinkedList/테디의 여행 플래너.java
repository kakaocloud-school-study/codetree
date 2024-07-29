import java.util.*;
import java.io.*;

public class Main {
    static class Node {
        String data;
        Node prev, next;

        Node(String data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    public static void connect(Node s, Node e) {
        if (s != null) {
            s.next = e;
        }
        if (e != null) {
            e.prev = s;
        }
    }

    public static void insertNext(Node target, Node s) {
        connect(s, target.next);
        connect(target, s);
    }

    public static void pop(Node u) {
        connect(u.prev, u.next);
        u.prev = u.next = null;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        Node pin = null, prev = null;

        //원형 연결
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            String x = st.nextToken();
            Node target = new Node(x);

            if (i == 1) {
                pin = target;
            } else {
                connect(prev, target);
            }

            //맨 마지막 도시와 맨 처음 도시 연결
            if (i == n) {
                connect(target, pin);
            }

            prev = target;
        }

        while (q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int option = Integer.parseInt(st.nextToken());

            if (option == 1) {
                if (pin.next != null) {
                    pin = pin.next;
                }
            }
            if (option == 2) {
                if (pin.prev != null) {
                    pin = pin.prev;
                }
            }

            if (option == 3) {
                if (pin.next != pin) {
                    pop(pin.next);
                }
            }

            if (option == 4) {
                String x = st.nextToken();
                insertNext(pin, new Node(x));
            }

            if (pin.next == pin.prev || pin.next == null || pin.prev == null) {
                System.out.println(-1);
            } else {
                System.out.println(pin.prev.data + " " + pin.next.data);
            }
        }
    }
}