import sys


class Node:
    def __init__(self, value):
        self.value = value
        self.prev = None
        self.next = None


def sol(n, cur, queries):
    def insert_prev(node):
        old_prev = cur.prev
        if old_prev != None:
            old_prev.next = node
            node.prev = old_prev
        cur.prev = node
        node.next = cur

    def insert_next(node):
        old_next = cur.next
        if old_next != None:
            old_next.prev = node
            node.next = old_next
        cur.next = node
        node.prev = cur

    def process_query(q):
        nonlocal cur
        if len(q) > 1:
            cmd, value = q
        else:
            cmd = q[0]

        if cmd == '1':
            insert_prev(Node(value))
        elif cmd == '2':
            insert_next(Node(value))
        elif cmd == '3':
            if cur.prev != None:
                cur = cur.prev
        elif cmd == '4':
            if cur.next != None:
                cur = cur.next

    def print_cur():
        prev_value = '(Null)' if cur.prev == None else cur.prev.value
        next_value = '(Null)' if cur.next == None else cur.next.value

        print(prev_value, cur.value, next_value)

    for q in queries:
        process_query(q)
        print_cur()


s_init = sys.stdin.readline().strip()
cur = Node(s_init)
n = int(sys.stdin.readline())
queries = [sys.stdin.readline().split() for _ in range(n)]

sol(n, cur, queries)
