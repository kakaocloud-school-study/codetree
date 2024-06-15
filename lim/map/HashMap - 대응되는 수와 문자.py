import sys


def sol(my_map, queries):
    for q in queries:
        print(my_map[q])


n, m = map(int, sys.stdin.readline().split())
words = [sys.stdin.readline().strip() for _ in range(n)]
my_map = dict()
for i, word in enumerate(words):
    my_map[str(i+1)] = word
    my_map[word] = str(i+1)
queries = [sys.stdin.readline().strip() for _ in range(m)]

sol(my_map, queries)
