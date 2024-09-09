import sys

INT_MAX = sys.maxsize

# 변수 선언 및 입력 받기
n = int(input())  # 점의 개수
x, y = [], []  # 각 점의 x좌표와 y좌표를 저장할 리스트

# L, R 배열 선언
# L: 0번 점부터 i번 점까지의 거리 합
# R: i번 점부터 마지막 점까지의 거리 합
L, R = [0] * n, [0] * n

# 최종 답을 저장할 변수, 초기값은 매우 큰 값으로 설정
min_distance = INT_MAX

# n개의 점 좌표 입력 받기
for _ in range(n):
    # 각각의 점의 x좌표와 y좌표를 입력 받아 리스트에 추가
    given_x, given_y = map(int, input().split())
    x.append(given_x)
    y.append(given_y)

# L 배열 계산: 0번 점부터 i번 점까지 순서대로 이동하는 거리 계산
L[0] = 0  # 첫 점에서 시작이므로 거리 0
for i in range(1, n):
    # 이전 점에서 현재 점까지의 거리 누적
    L[i] = L[i - 1] + abs(x[i] - x[i - 1]) + abs(y[i] - y[i - 1])

# R 배열 계산: 마지막 점에서 i번 점까지 역순으로 이동하는 거리 계산
R[n - 1] = 0  # 마지막 점에서 끝이므로 거리 0
for i in range(n - 2, -1, -1):
    # 다음 점에서 현재 점까지의 거리 누적
    R[i] = R[i + 1] + abs(x[i + 1] - x[i]) + abs(y[i + 1] - y[i])

# 중간 점을 건너뛰었을 때의 최소 거리를 계산
for i in range(1, n - 1):
    # i번 점을 건너뛰고 이동했을 때의 총 거리 계산
    skip_distance = L[i - 1] + R[i + 1] + abs(x[i + 1] - x[i - 1]) + abs(y[i + 1] - y[i - 1])
    # 최소 거리 갱신
    min_distance = min(min_distance, skip_distance)

# 최소 거리 출력
print(min_distance)
