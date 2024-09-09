# 입력 값 처리
n = int(input())  # 경기의 수
matches = [input() for _ in range(n)]  # 각 경기에서 낸 모양

# L과 R 배열을 선언
# L: 0번부터 i번까지 같은 모양을 냈을 때 이길 수 있는 최대 횟수
# R: i번부터 마지막까지 같은 모양을 냈을 때 이길 수 있는 최대 횟수
L, R = [0] * n, [0] * n

# 최종 결과를 저장할 변수
max_wins = 0

# L 배열 채우기 (앞에서부터 같은 모양을 낸 경우)
for shape in "PHS":  # 'P', 'H', 'S' 각각의 경우를 확인
    consecutive_wins = 0  # 같은 모양을 연속으로 낸 횟수
    for i in range(n):
        if matches[i] == shape:
            consecutive_wins += 1  # 같은 모양을 내면 카운트 증가
        L[i] = max(L[i], consecutive_wins)  # 최댓값 갱신

# R 배열 채우기 (뒤에서부터 같은 모양을 낸 경우)
for shape in "PHS":
    consecutive_wins = 0  # 같은 모양을 연속으로 낸 횟수
    for i in range(n - 1, -1, -1):
        if matches[i] == shape:
            consecutive_wins += 1  # 같은 모양을 내면 카운트 증가
        R[i] = max(R[i], consecutive_wins)  # 최댓값 갱신

# 선택을 중간에 바꿨을 때의 최대 이기는 횟수 계산
for i in range(n - 1):
    # i번까지는 하나의 모양만 냈고, i+1번부터는 다른 모양만 낸 경우
    max_wins = max(max_wins, L[i] + R[i + 1])

# 최종 결과 출력
print(max_wins)
