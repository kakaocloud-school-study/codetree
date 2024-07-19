import sys


def sol(n, m, arr, queries):

    def search(target_num):
        left, right = 0, n-1
        while left <= right:
            mid = (left + right) // 2
            if target_num == arr[mid]:
                return mid + 1
            elif target_num < arr[mid]:
                right = mid - 1
            else:
                left = mid + 1
        return -1

    for q in queries:
        print(search(q))


n, m = map(int, sys.stdin.readline().split())
arr = list(map(int, sys.stdin.readline().split()))
queries = [int(sys.stdin.readline()) for _ in range(m)]

sol(n, m, arr, queries)
