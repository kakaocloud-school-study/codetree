# 입력 받기
n = int(input())
dist = list(map(int, input().split()))
cost = list(map(int, input().split()))

# 초기 설정
ans = 0
min_price = cost[0]

# 각 도시를 순회하며 최소 비용 계산
for i in range(n - 1):
    if cost[i] < min_price:
        min_price = cost[i]
    ans += min_price * dist[i]

# 결과 출력
print(ans)
