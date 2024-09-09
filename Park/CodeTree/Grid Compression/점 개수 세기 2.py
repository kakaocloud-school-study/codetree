from sortedcontainers import SortedSet

MAX_M = 5000

# 변수 선언 및 입력 처리
n, q = map(int, input().split())  # n: 점의 개수, q: 질의 개수
nums = SortedSet()  # 좌표 압축을 위한 정렬된 집합
mapper = {}  # 좌표 압축을 위한 매핑
prefix_sum = [[0] * (MAX_M + 2) for _ in range(MAX_M + 2)]  # 누적합 배열

points = [tuple(map(int, input().split())) for _ in range(n)]  # 점 입력
queries = [tuple(map(int, input().split())) for _ in range(q)]  # 질의 입력

# x보다 같거나 큰 첫 번째 숫자의 좌표압축 결과 반환
def get_lower_boundary(x):
    return nums.bisect_left(x) + 1

# x보다 같거나 작은 첫 번째 숫자의 좌표압축 결과 반환
def get_upper_boundary(x):
    return nums.bisect_right(x)

# 직사각형 구간 내 점의 개수 계산
def get_sum(x1, y1, x2, y2):
    return (prefix_sum[x2][y2] 
            - prefix_sum[x1 - 1][y2] 
            - prefix_sum[x2][y1 - 1] 
            + prefix_sum[x1 - 1][y1 - 1])

# 각 좌표를 정렬된 집합에 추가하여 좌표 압축 준비
for x, y in points:
    nums.add(x)
    nums.add(y)

# 좌표 압축을 위한 매핑 생성
for idx, num in enumerate(nums, 1):
    mapper[num] = idx

# 주어진 점들에 대해 누적합 배열을 채움
for x, y in points:
    new_x, new_y = mapper[x], mapper[y]
    prefix_sum[new_x][new_y] += 1

# 2차원 누적합 배열 생성
for i in range(1, len(nums) + 1):
    for j in range(1, len(nums) + 1):
        prefix_sum[i][j] += (prefix_sum[i - 1][j] 
                             + prefix_sum[i][j - 1] 
                             - prefix_sum[i - 1][j - 1])

# 각 질의에 대해 구간 내 점의 개수를 계산
for x1, y1, x2, y2 in queries:
    # 각 좌표에 대해 좌표압축된 값을 찾음
    new_x1 = get_lower_boundary(x1)
    new_y1 = get_lower_boundary(y1)
    new_x2 = get_upper_boundary(x2)
    new_y2 = get_upper_boundary(y2)

    # 구간 내 점의 개수를 누적합을 사용해 계산
    result = get_sum(new_x1, new_y1, new_x2, new_y2)
    print(result)
