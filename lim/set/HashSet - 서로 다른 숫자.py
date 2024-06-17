import sys


def sol(n, arr):
    my_set = set()

    for num in arr:
        my_set.add(num)
    
    print(len(my_set))


n = int(sys.stdin.readline())
arr = list(map(int, sys.stdin.readline().split()))

sol(n, arr)
