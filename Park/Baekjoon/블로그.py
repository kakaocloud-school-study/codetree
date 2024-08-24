# 입력 받기
N, X = map(int, input().split())  # N일과 X일을 입력 받음
visitors = list(map(int, input().split()))  # 방문자 수 리스트

# 초기 슬라이딩 윈도우 설정
current_sum = sum(visitors[:X])  # 첫 X일의 방문자 수 합
max_sum = current_sum  # 최대 방문자 수 합
count = 1  # 최대 방문자 수 합이 발생한 기간의 개수

# 슬라이딩 윈도우로 X일 간의 방문자 수 합을 계산
for i in range(X, N):
    current_sum += visitors[i] - visitors[i - X]  # 윈도우를 한 칸 오른쪽으로 이동
    if current_sum > max_sum:  # 새로운 최대값 발견 시
        max_sum = current_sum
        count = 1  # 최대값이 갱신되면 기간 개수 초기화
    elif current_sum == max_sum:  # 최대값과 동일한 값이 나온 경우
        count += 1  # 기간 개수 증가

# 출력
if max_sum == 0:
    print("SAD")
else:
    print(max_sum)
    print(count)
