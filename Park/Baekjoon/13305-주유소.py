def min_cost_to_travel(N, road_lengths, gas_prices):
    total_cost = 0  # 총 비용
    min_price = gas_prices[0]  # 현재까지의 최소 주유 가격

    for i in range(N - 1):
        # 현재 도시에서 다음 도시까지 가는 데 필요한 기름 비용 계산
        total_cost += min_price * road_lengths[i]
        # 다음 도시의 주유 가격이 더 저렴하면 갱신
        if gas_prices[i + 1] < min_price:
            min_price = gas_prices[i + 1]

    return total_cost

# 예제 입력 1
N = 4
road_lengths = [2, 3, 1]
gas_prices = [5, 2, 4, 1]
print(min_cost_to_travel(N, road_lengths, gas_prices))  # 출력: 18

# 예제 입력 2
N = 4
road_lengths = [3, 3, 4]
gas_prices = [1, 1, 1, 1]
print(min_cost_to_travel(N, road_lengths, gas_prices))  # 출력: 10
