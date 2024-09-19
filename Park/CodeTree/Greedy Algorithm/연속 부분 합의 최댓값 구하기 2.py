import sys

# 최솟값을 설정.
INT_MIN = -sys.maxsize

# 변수 선언 및 입력
n = int(input())
arr = list(map(int, input().split()))

# 최댓값을 저장할 변수 초기화
max_sum = INT_MIN

# 현재 연속 부분 수열의 합을 저장할 변수
current_sum = 0

for i in range(n):
    # 현재 연속 부분 수열의 합이 0보다 작다면, 새로운 수열을 시작.
    if current_sum < 0:
        current_sum = arr[i]
    else:
        # 그렇지 않다면 현재 원소를 기존 부분 수열에 추가.
        current_sum += arr[i]
    
    # 최댓값을 갱신.
    max_sum = max(max_sum, current_sum)

# 결과 출력
print(max_sum)
