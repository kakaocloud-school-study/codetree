import sys


def sol(n, queries):
    my_set = set()

    def process_query(q):
        cmd, key = q
        if cmd == 'add':
            my_set.add(key)
        elif cmd == 'remove':
            my_set.remove(key)
        elif cmd == 'find':
            if key in my_set:
                print('true')
            else:
                print('false')
    for q in queries:
        process_query(q)


n = int(sys.stdin.readline())
queries = [sys.stdin.readline().split() for _ in range(n)]

sol(n, queries)
