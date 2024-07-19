import sys


def sol(n, queries):
    my_map = dict()

    def process_query(q):
        cmd = q[0]
        if cmd == 'add':
            key, value = q[1:]
            my_map[key] = value
        elif cmd == 'remove':
            key = q[1]
            my_map.pop(key)
        elif cmd == 'find':
            key = q[1]
            value = my_map.get(key)
            if value == None:
                print('None')
            else:
                print(value)
    for q in queries:
        process_query(q)


n = int(sys.stdin.readline())
queries = [sys.stdin.readline().split() for _ in range(n)]

sol(n, queries)
