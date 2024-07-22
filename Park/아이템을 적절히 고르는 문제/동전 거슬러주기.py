import sys
sys.setrecursionlimit(10000)

INT_MAX = sys.maxsize

# 입력 받기
n, m = map(int, input().split())
coin = [0] + list(map(int, input().split()))

min_cnt = INT_MAX  # 초기값 설정

def find_min_cnt(current_sum, coin_count):
    global min_cnt
    if current_sum == m:
        min_cnt = min(min_cnt, coin_count)
        return
    for i in range(1, n + 1):
        if current_sum + coin[i] <= m:
            find_min_cnt(current_sum + coin[i], coin_count + 1)

find_min_cnt(0, 0)  # 초기 호출

if min_cnt == INT_MAX:
    min_cnt = -1

print(min_cnt)
