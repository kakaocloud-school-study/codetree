# 입력 받기
n, k = map(int, input().split())
coins = [int(input()) for _ in range(n)]

# 필요한 동전의 최소 개수를 저장할 변수
min_coins = 0

# 큰 동전부터 사용하기 위해 역순으로 정렬
coins.sort(reverse=True)

# 금액을 만들기 위해 각 동전의 사용 개수 계산
for coin in coins:
    if k == 0:
        break
    count = k // coin
    min_coins += count
    k -= count * coin

# 결과 출력
print(min_coins)
