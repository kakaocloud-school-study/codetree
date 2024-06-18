import sys

from sortedcontainers import SortedSet


def sol(n, queries):
    my_set = SortedSet()

    def process_query(q):
        if len(q) < 2:
            cmd = q[0]
        else:
            cmd, key = q
            key = int(key)

        if cmd == 'add':
            my_set.add(key)
        elif cmd == 'remove':
            my_set.remove(key)
        elif cmd == 'lower_bound':
            if len(my_set) == 0:
                print('None')
                return
            result = my_set.bisect_left(key)
            if result == len(my_set):
                print('None')
                return
            print(my_set[result])
        elif cmd == 'upper_bound':
            if len(my_set) == 0:
                print('None')
                return
            result = my_set.bisect_right(key)
            if result == len(my_set):
                print('None')
                return
            print(my_set[result])
        elif cmd == 'largest':
            if len(my_set) == 0:
                print('None')
            else:
                print(my_set[-1])
        elif cmd == 'smallest':
            if len(my_set) == 0:
                print('None')
            else:
                print(my_set[0])
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
