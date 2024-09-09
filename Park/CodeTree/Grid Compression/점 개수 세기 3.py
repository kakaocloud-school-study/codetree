from sortedcontainers import SortedSet

# 입력 값 처리:
n, q = map(int, input().split())  # n: 배열의 크기, q: 질의 개수
arr = list(map(int, input().split()))  # 좌표값 배열
queries = [tuple(map(int, input().split())) for _ in range(q)]  # 질의 입력

# 좌표값들을 정렬된 집합(SortedSet)에 저장
sorted_nums = SortedSet(arr)

# 정렬된 좌표값을 1번부터 순서대로 매핑(mapper)에 저장
mapper = {}
for idx, num in enumerate(sorted_nums, 1):
    mapper[num] = idx  # num을 idx로 매핑

# 각 질의에 대해
# [a, b] 범위에 속하는 좌표의 수를 계산하여 출력
for a, b in queries:
    start = mapper[a]  # a에 해당하는 매핑 값
    end = mapper[b]    # b에 해당하는 매핑 값
    print(end - start + 1)  # 두 점 사이의 수 계산 후 출력
