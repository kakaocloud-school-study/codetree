import sys


def sol(n, m, arr, queries):

    def search(target_num):
        left, right = 0, n-1
        answer = -1
        while left <= right:
            mid = (left + right) // 2
            if target_num <= arr[mid]:
                right = mid - 1
                if target_num == arr[mid]:
                    answer = mid + 1
            else:
                left = mid + 1
        return answer

    for q in queries:
        print(search(q))


n, m = map(int, sys.stdin.readline().split())
arr = list(map(int, sys.stdin.readline().split()))
queries = list(map(int, sys.stdin.readline().split()))

sol(n, m, arr, queries)
