import heapq
import sys


def sol(n, queries):
    hq = []

    def process_query(q):
        if len(q) < 2:
            cmd = q[0]
        else:
            cmd, item = q
            item = int(item)

        if cmd == 'push':
            heapq.heappush(hq, -item)
        elif cmd == 'pop':
            item = heapq.heappop(hq)
            print(-item)
        elif cmd == 'size':
            print(len(hq))
        elif cmd == 'empty':
            print(1 if len(hq) == 0 else 0)
        elif cmd == 'top':
            print(-hq[0])
    for q in queries:
        process_query(q)


n = int(sys.stdin.readline())
queries = [sys.stdin.readline().split() for _ in range(n)]

sol(n, queries)
