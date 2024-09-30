# 입력 받기
H, W = map(int, input().split())
height = list(map(int, input().split()))

# 왼쪽 최댓값과 오른쪽 최댓값을 저장할 배열
left_max = [0] * W
right_max = [0] * W

# 왼쪽에서부터의 최댓값 계산
left_max[0] = height[0]
for i in range(1, W):
    left_max[i] = max(left_max[i - 1], height[i])

# 오른쪽에서부터의 최댓값 계산
right_max[W - 1] = height[W - 1]
for i in range(W - 2, -1, -1):
    right_max[i] = max(right_max[i + 1], height[i])

# 빗물이 고일 수 있는 양 계산
water = 0
for i in range(W):
    water += max(0, min(left_max[i], right_max[i]) - height[i])

print(water)
