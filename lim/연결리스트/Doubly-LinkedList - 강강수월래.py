import sys

node_by_id = dict()


class Node:
    def __init__(self, value):
        global node_by_id
        self.value = value
        self.prev = None
        self.next = None

        node_by_id[value] = self


def sol(queries):
    def concat_circle(a_id, b_id):
        a_node = node_by_id[a_id]
        b_node = node_by_id[b_id]
        a_next_node = a_node.next
        b_prev_node = b_node.prev

        a_node.next = b_node
        b_node.prev = a_node

        a_next_node.prev = b_prev_node
        b_prev_node.next = a_next_node

    def divide_circle(a_id, b_id):
        a_node = node_by_id[a_id]
        b_node = node_by_id[b_id]
        a_prev_node = a_node.prev
        a_end_node = b_node.prev

        a_node.prev = a_end_node
        a_end_node.next = a_node

        a_prev_node.next = b_node
        b_node.prev = a_prev_node

    def get_min_at_circle(member_id):
        node = node_by_id[member_id]
        min_id = member_id
        while node.prev.value != member_id:
            node = node.prev
            min_id = min(min_id, node.value)
        return min_id

    def print_circle(member_id):
        node = node_by_id[member_id]
        print(node.value, end=' ')
        while node.prev.value != member_id:
            node = node.prev
            print(node.value, end=' ')

    def process_query(q):
        if len(q) > 2:
            cmd, a, b = q
        else:
            cmd, a = q

        if cmd == 1:
            concat_circle(a, b)
        elif cmd == 2:
            divide_circle(a, b)
        elif cmd == 3:
            id = get_min_at_circle(a)
            print_circle(id)

    for q in queries:
        process_query(q)


n, m, q = map(int, sys.stdin.readline().split())
circles = [list(map(int, sys.stdin.readline().split()))[1:] for _ in range(m)]
queries = [list(map(int, sys.stdin.readline().split())) for _ in range(q)]

for circle in circles:
    root = None
    prev_node = None
    for member_id in circle:
        node = Node(member_id)
        if root == None:
            root = node
            prev_node = node
            continue
        prev_node.next = node
        node.prev = prev_node
        prev_node = node
    prev_node.next = root
    root.prev = prev_node

sol(queries)
