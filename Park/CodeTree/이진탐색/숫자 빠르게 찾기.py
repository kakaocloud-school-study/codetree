def binary_search(arr, target):
    left, right = 0, len(arr) - 1
    while left <= right:
        mid = (left + right) // 2
        if arr[mid] == target:
            return mid + 1  # 1-based index
        elif arr[mid] < target:
            left = mid + 1
        else:
            right = mid - 1
    return -1

# 입력 받기
n, m = map(int, input().split())
n_list = list(map(int, input().split()))
m_list = [int(input()) for _ in range(m)]

# 각 숫자에 대해 이진 탐색 수행
results = []
for num in m_list:
    result = binary_search(n_list, num)
    results.append(result)

# 결과 출력
for result in results:
    print(result)
