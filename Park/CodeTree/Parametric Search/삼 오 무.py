import sys

# 입력 받기
n = int(input())

def count_non_multiples(k):
    # 1부터 k까지의 수 중에서 3 또는 5의 배수가 아닌 수의 개수를 반환.
    return k - (k // 3 + k // 5 - k // 15)

# 이진 탐색을 위한 범위 설정
left = 1
right = n * 2  # 3과 5의 배수를 제외한 수의 밀도를 고려하여 범위를 설정.
result = 0

while left <= right:
    mid = (left + right) // 2
    non_multiples = count_non_multiples(mid)
    
    if non_multiples >= n:
        result = mid  # 조건을 만족하는 후보 중 최솟값을 갱신.
        right = mid - 1
    else:
        left = mid + 1

print(result)
