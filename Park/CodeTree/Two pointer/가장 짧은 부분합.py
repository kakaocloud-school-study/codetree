import sys

# 파이썬에서 사용할 수 있는 가장 큰 정수를 INT_MAX로 설정
INT_MAX = sys.maxsize

# 입력 값을 받아옵니다.
n, s = map(int, input().split())  # n: 배열의 크기, s: 목표 합
arr = [0] + list(map(int, input().split()))  # 입력 배열, 인덱스 편의를 위해 0을 추가

# 최단 구간 길이를 저장할 변수, 초기값은 매우 큰 값으로 설정
min_length = INT_MAX

# 투 포인터 알고리즘을 사용하여 구간을 탐색합니다.
current_sum = 0  # 현재 구간의 합을 저장하는 변수
right_pointer = 0  # 구간의 오른쪽 끝을 가리키는 포인터

# 왼쪽 포인터를 하나씩 이동하며 구간을 설정
for left_pointer in range(1, n + 1):
    # 현재 구간 합이 s보다 작은 동안 오른쪽 포인터를 이동
    while right_pointer + 1 <= n and current_sum < s:
        right_pointer += 1
        current_sum += arr[right_pointer]

    # 구간 합이 s보다 작으면 더 이상 탐색할 필요 없음
    if current_sum < s:
        break

    # 현재 구간이 조건을 만족할 때, 구간의 길이를 최소값으로 갱신
    min_length = min(min_length, right_pointer - left_pointer + 1)

    # 다음 구간으로 넘어가기 전에 왼쪽 포인터에 해당하는 값을 합에서 제외
    current_sum -= arr[left_pointer]

# 불가능한 경우, 즉 조건을 만족하는 구간이 없을 때 -1 출력
if min_length == INT_MAX:
    min_length = -1

# 결과 출력
print(min_length)
