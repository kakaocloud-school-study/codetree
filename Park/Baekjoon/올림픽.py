# 입력 받기
N, K = map(int, input().split())
countries = []

for _ in range(N):
    country_info = list(map(int, input().split()))
    countries.append(country_info)

# 금, 은, 동메달 순으로 내림차순 정렬
countries.sort(key=lambda x: (-x[1], -x[2], -x[3]))

# 등수 계산
rank = 1
for i in range(N):
    if countries[i][0] == K:
        K_rank = rank
        break
    if i < N - 1 and (countries[i][1], countries[i][2], countries[i][3]) != (countries[i+1][1], countries[i+1][2], countries[i+1][3]):
        rank = i + 2

# 결과 출력
print(K_rank)
