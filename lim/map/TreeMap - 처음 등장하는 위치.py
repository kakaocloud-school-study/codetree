import sys


def sol(n, arr):
    my_map = dict()

    for i, num in enumerate(arr):
        if my_map.get(num) == None:
            my_map[num] = i+1
    for key in sorted(my_map.keys()):
        print(key, my_map[key])


n = int(sys.stdin.readline())
arr = list(map(int, sys.stdin.readline().split()))

sol(n, arr)
