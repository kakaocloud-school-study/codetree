# 변수 선언 및 입력 받기
n = int(input())  # 문자열 길이
word = input()    # 문자열 입력

# L과 R 배열을 0으로 초기화
L = [0] * n  # L[i]는 0부터 i까지 'C'의 개수
R = [0] * n  # R[i]는 i부터 n-1까지 'W'의 개수
ans = 0      # 'COW' 패턴의 개수를 저장할 변수

# L 배열 계산: 각 인덱스까지 'C'의 누적 개수
if word[0] == 'C':
    L[0] = 1
for i in range(1, n):
    L[i] = L[i - 1] + (1 if word[i] == 'C' else 0)

# R 배열 계산: 각 인덱스부터 끝까지 'W'의 누적 개수
if word[n - 1] == 'W':
    R[n - 1] = 1
for i in range(n - 2, -1, -1):
    R[i] = R[i + 1] + (1 if word[i] == 'W' else 0)

# 'O'가 있는 위치에서 왼쪽의 'C'와 오른쪽의 'W'의 곱을 계산
for i in range(1, n - 1):
    if word[i] == 'O':
        ans += L[i - 1] * R[i + 1]

print(ans)
