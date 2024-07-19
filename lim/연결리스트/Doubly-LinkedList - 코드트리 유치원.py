import sys

next_id = 1
node_by_id = dict()


class Node:
    def __init__(self):
        global next_id
        global node_by_id
        self.value = next_id
        self.prev = None
        self.next = None
        next_id += 1

        node_by_id[self.value] = self


def sol(queries):
    global root
    root = Node()

    def create_new_line(size):
        start_node = Node()
        size -= 1

        end_node = start_node
        while size > 0:
            node = Node()
            end_node.next = node
            node.prev = end_node
            end_node = node
            size -= 1

        return start_node, end_node

    def get_by_id(target_id):
        global node_by_id
        return node_by_id[target_id]

    def insert_next(target_id, size):
        node = get_by_id(target_id)
        old_next = node.next
        start_node, end_node = create_new_line(size)
        if old_next != None:
            end_node.next = old_next
            old_next.prev = end_node
        node.next = start_node
        start_node.prev = node

    def insert_prev(target_id, size):
        global root

        node = get_by_id(target_id)
        old_prev = node.prev
        start_node, end_node = create_new_line(size)
        if old_prev != None:
            start_node.prev = old_prev
            old_prev.next = start_node
        else:
            root = start_node
        node.prev = end_node
        end_node.next = node

    def process_query(q):
        if len(q) > 2:
            cmd, a, b = q
        else:
            cmd, a = q

        if cmd == 1:
            insert_next(a, b)
        elif cmd == 2:
            insert_prev(a, b)
        elif cmd == 3:
            node = get_by_id(a)
            if node.next == None or node.prev == None:
                print(-1)
                return
            print(node.prev.value, node.next.value)

    for q in queries:
        process_query(q)


q = int(sys.stdin.readline())
queries = [list(map(int, sys.stdin.readline().split())) for _ in range(q)]

sol(queries)
