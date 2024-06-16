import sys

from sortedcontainers import SortedDict


def sol(n, queries):
    my_map = SortedDict()

    def process_query(q):
        cmd = q[0]
        if cmd == 'add':
            key, value = q[1:]
            my_map[int(key)] = value
        elif cmd == 'remove':
            key = q[1]
            my_map.pop(int(key))
        elif cmd == 'find':
            key = q[1]
            value = my_map.get(int(key))
            if value == None:
                print('None')
            else:
                print(value)
        elif cmd == 'print_list':
            if len(my_map) == 0:
                print('None')
                return
            for key in my_map.keys():
                print(my_map[int(key)], end=' ')
            print()
    for q in queries:
        process_query(q)


n = int(sys.stdin.readline())
queries = [sys.stdin.readline().split() for _ in range(n)]

sol(n, queries)
