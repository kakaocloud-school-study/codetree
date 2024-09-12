MAX_R = 200000  # 좌표 범위 상수

# 변수 선언 및 입력 받기
n = int(input())  # 선분의 개수
segments = [tuple(map(int, input().split())) for _ in range(n)]  # 각 선분의 시작, 끝 좌표
checked = [0] * (MAX_R + 1)  # 좌표별 겹침을 기록할 배열
ans = 0  # 최대로 겹친 횟수

# 각 선분의 시작점에서 +1, 끝점에서 -1
for x1, x2 in segments:
    checked[x1] += 1  # 선분이 시작되는 좌표에서는 겹침을 +1
    checked[x2] -= 1  # 선분이 끝나는 좌표에서는 겹침을 -1

# 좌표를 순회하면서 누적된 겹침 횟수를 계산
overlapped_cnt = 0  # 현재 위치에서의 누적된 겹침 횟수
for x in range(1, MAX_R + 1):
    overlapped_cnt += checked[x]  # 이전 위치에서의 겹침 수를 누적
    ans = max(ans, overlapped_cnt)  # 가장 큰 겹침 횟수를 기록

print(ans)  # 최대로 겹친 구간 출력
