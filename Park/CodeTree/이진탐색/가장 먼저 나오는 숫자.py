import bisect

# 변수 선언 및 입력:
n, m = map(int, input().split())
arr = list(map(int, input().split()))
queries = list(map(int, input().split()))

# 각 쿼리에 대해 처리합니다.
for query in queries:
    # bisect_left를 사용하여 'query'가 삽입될 위치를 찾기.
    idx = bisect.bisect_left(arr, query)
    if idx < n and arr[idx] == query:
        # 문제에서 인덱스는 1부터 시작하므로 1을 더하기.
        print(idx + 1)
    else:
        print(-1)
