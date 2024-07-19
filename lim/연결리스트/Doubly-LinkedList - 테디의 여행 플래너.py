import sys


class Node:
    def __init__(self, value):
        self.value = value
        self.prev = None
        self.next = None


def sol(n, q, pinned, queries):
    def remove_next():
        next = pinned.next
        if next == None:
            return

        pinned.next = next.next
        if next.next != None:
            next.next.prev = pinned
        next.next = None
        next.prev = None

    def insert_next(node):
        old_next = pinned.next
        if old_next != None:
            old_next.prev = node
            node.next = old_next
        pinned.next = node
        node.prev = pinned

    def process_query(q):
        nonlocal pinned
        if len(q) > 1:
            cmd, value = q
        else:
            cmd = q[0]

        if cmd == '1':
            if pinned.next != None:
                pinned = pinned.next
        elif cmd == '2':
            if pinned.prev != None:
                pinned = pinned.prev
        elif cmd == '3':
            remove_next()
        elif cmd == '4':
            insert_next(Node(value))

    def print_pinned():
        if pinned.prev == None or pinned.next == None or pinned.next.value == pinned.prev.value:
            print(-1)
        else:
            print(pinned.prev.value, pinned.next.value)

    for q in queries:
        process_query(q)
        print_pinned()


n, q = map(int, sys.stdin.readline().split())
cities = sys.stdin.readline().split()
pinned = Node(cities[0])
prev = pinned
for city in cities[1:]:
    node = Node(city)
    prev.next = node
    node.prev = prev
    prev = node
prev.next = pinned
pinned.prev = prev
queries = [sys.stdin.readline().split() for _ in range(q)]

sol(n, q, pinned, queries)
