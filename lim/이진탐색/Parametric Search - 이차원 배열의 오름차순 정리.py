import sys
from bisect import bisect_left


def sol(n, k):
    nn_nums = [i**2 for i in range(n+1)]
    triangles = [0] * (n+1)
    triangles[1] = 1
    for i in range(2, n+1):
        triangles[i] = triangles[i-1] + i
    idx = bisect_left(nn_nums, k)
    nn_order = triangles[idx] - triangles[n-idx] * 2
    sqrt_nn = idx
    order = nn_order
    for row in range(sqrt_nn, n+1):
        col = sqrt_nn*2 - row
        if order == k:
            print(row*col)
            return
        if row == col:
            order -= 1
        else:
            order -= 2
    for row in range(sqrt_nn, n+1):
        col = sqrt_nn*2 - 1 - row
        if order == k:
            print(row*col)
            return
        if row == col:
            order -= 1
        else:
            order -= 2


n = int(sys.stdin.readline())
k = int(sys.stdin.readline())

sol(n, k)
