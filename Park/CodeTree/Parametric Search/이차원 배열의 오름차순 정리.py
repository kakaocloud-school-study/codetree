# 입력 받기
n = int(input())
k = int(input())

def count_numbers(x):
    # n x n 곱셈표에서 x 이하의 수의 개수를 계산.
    count = 0
    for i in range(1, n + 1):
        count += min(n, x // i)
    return count

# 이진 탐색을 위한 범위 설정
left = 1
right = n * n
answer = 0

while left <= right:
    mid = (left + right) // 2
    total = count_numbers(mid)
    
    if total < k:
        left = mid + 1
    else:
        answer = mid  # 조건을 만족하는 후보 중 최솟값을 갱신.
        right = mid - 1

# 정답 출력
print(answer)
