import sys


def sol(n, k, queries):
    visited_positions_by_id = [set([i]) for i in range(n)]
    arr = list(range(n))

    def swap(idx1, idx2):
        arr[idx1], arr[idx2] = arr[idx2], arr[idx1]
        id1, id2 = arr[idx1], arr[idx2]
        visited_positions_by_id[id1].add(idx1)
        visited_positions_by_id[id2].add(idx2)

    for _ in range(3):
        for idx1, idx2 in queries:
            swap(idx1, idx2)

    for visited_positions in visited_positions_by_id:
        print(len(visited_positions))


n, k = map(int, sys.stdin.readline().split())
queries = [list(map(lambda x: int(x)-1, sys.stdin.readline().split()))
           for _ in range(k)]

sol(n, k, queries)
