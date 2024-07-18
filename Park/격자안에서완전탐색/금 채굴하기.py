# 변수 선언 및 입력
n, m = map(int, input().split())
grid = [list(map(int, input().split())) for _ in range(n)]

# 마름모의 넓이를 계산하는 함수입니다.
def calculate_area(k):
    return k * k + (k + 1) * (k + 1)

# 주어진 중심점(row, col)과 k에 대해 마름모 내의 금 개수를 계산하는 함수입니다.
def count_gold_in_diamond(row, col, k):
    total_gold = 0
    for i in range(n):
        for j in range(n):
            if abs(row - i) + abs(col - j) <= k:
                total_gold += grid[i][j]
    return total_gold

max_gold = 0

# 모든 격자 위치에 대해 마름모의 중심으로 고려합니다.
for row in range(n):
    for col in range(n):
        for k in range(2 * (n - 1) + 1):
            num_of_gold = count_gold_in_diamond(row, col, k)
            
            # 손해를 보지 않으면서 채굴할 수 있는 최대 금의 개수를 업데이트합니다.
            if num_of_gold * m >= calculate_area(k):
                max_gold = max(max_gold, num_of_gold)

print(max_gold)
