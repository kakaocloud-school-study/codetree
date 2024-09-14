import bisect

# 변수 선언 및 입력:
n, m = map(int, input().split())
arr = list(map(int, input().split()))

# 이진탐색을 진행하기 전에 정렬을 진행.
arr.sort()

# m개의 질의에 대한 답을 계산.
for _ in range(m):
    a, b = map(int, input().split())

    # 'a' 이상인 첫 번째 위치를 찾기.
    left = bisect.bisect_left(arr, a)
    # 'b'를 초과하는 첫 번째 위치를 찾기.
    right = bisect.bisect_right(arr, b)

    # 두 위치의 차이가 [a, b] 구간에 있는 원소의 갯수.
    count = right - left
    print(count)
