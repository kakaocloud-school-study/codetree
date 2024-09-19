# 변수 선언 및 입력
n = int(input())
arr = list(map(int, input().split()))

# 필요한 횟수 계산
flip_count = 0

for i in range(1, n):
    # 이전 칸이 0인 경우 현재 칸을 선택해야 함
    if arr[i - 1] == 0:
        flip_count += 1
        arr[i - 1] = 1          # 이전 칸을 1로 바꿈
        arr[i] ^= 1             # 현재 칸을 반전
        # 다음 칸이 범위 내에 있을 때만 반전
        if i + 1 < n:
            arr[i + 1] ^= 1     # 다음 칸을 반전

# 마지막 칸이 0이면 불가능한 경우
if arr[n - 1] == 0:
    flip_count = -1

print(flip_count)
