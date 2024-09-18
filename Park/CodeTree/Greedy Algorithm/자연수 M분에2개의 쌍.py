# 입력받을 변수와 초기화
n = int(input())
ans = 0

# 입력받은 데이터를 저장할 리스트
nums = []
for _ in range(n):
    x, y = map(int, input().split())
    nums.append((y, x))

# y를 기준으로 오름차순 정렬
nums.sort()

# 매칭을 진행할 인덱스 설정
left, right = 0, n - 1

while left <= right:
    left_y, left_x = nums[left]
    right_y, right_x = nums[right]

    # 최댓값 갱신
    ans = max(ans, left_y + right_y)

    # 왼쪽의 개수가 더 적을 경우
    if left_x < right_x:
        # 오른쪽의 개수를 줄여줌
        nums[right] = (right_y, right_x - left_x)
        # 왼쪽 포인터 이동
        left += 1

    # 오른쪽의 개수가 더 적을 경우
    elif left_x > right_x:
        # 왼쪽의 개수를 줄여줌
        nums[left] = (left_y, left_x - right_x)
        # 오른쪽 포인터 이동
        right -= 1

    # 양쪽 개수가 동일한 경우
    else:
        left += 1
        right -= 1

# 결과 출력
print(ans)
