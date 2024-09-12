from sortedcontainers import SortedSet

# 입력 받기
n = int(input())  # 선분의 개수 입력
segments = [
    tuple(map(int, input().split()))  # 각 선분의 y, x1, x2 값 입력
    for _ in range(n)
]

# 보이는 선분을 기록할 리스트 (처음에는 모두 False로 설정)
visible = [False] * n

# 각 선분을 시작점과 끝점으로 나누어 처리
# (x좌표, 시작/끝 플래그, 선분 번호, y값) 형식으로 저장
points = []
for i in range(n):
    y, x1, x2 = segments[i]
    points.append((x1, +1, i, y))  # 시작점
    points.append((x2, -1, i, y))  # 끝점

# x좌표 순으로 정렬 (같은 x좌표일 경우 시작점이 먼저 오게 정렬됨)
points.sort()

# 현재 보이는 선분을 관리할 treeset (y값이 작은 선분이 우선)
segs = SortedSet()

# 모든 점을 순차적으로 처리
for x, event_type, idx, y in points:
    # 시작점일 경우, 해당 선분을 treeset에 추가
    if event_type == +1:
        segs.add((y, idx))  # (y값, 선분 번호) 형태로 추가

    # 끝점일 경우, 해당 선분을 treeset에서 제거
    else:
        segs.remove((y, idx))  # (y값, 선분 번호) 형태로 제거

    # 현재 남아있는 선분이 없는 경우는 처리하지 않음
    if not segs:
        continue

    # 가장 위에 있는(즉, y값이 가장 작은) 선분을 찾아서 보이는 것으로 처리
    _, top_index = segs[0]
    visible[top_index] = True

# 한 번이라도 보였던 선분의 개수를 세서 출력
result = sum(visible)
print(result)
