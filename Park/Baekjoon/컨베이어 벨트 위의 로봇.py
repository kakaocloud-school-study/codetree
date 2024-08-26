def simulate_conveyor_belt(N, K, durability):
    # 로봇 위치를 저장하는 리스트
    robots = [False] * (2 * N)
    step = 0

    while True:
        step += 1

        # 1. 벨트가 회전
        durability = [durability[-1]] + durability[:-1]
        robots = [robots[-1]] + robots[:-1]

        # 내리는 위치에 로봇이 도달하면 내림
        if robots[N - 1]:
            robots[N - 1] = False

        # 2. 가장 먼저 올라간 로봇부터 이동
        for i in range(N - 2, -1, -1):
            if robots[i] and not robots[i + 1] and durability[i + 1] > 0:
                robots[i] = False
                robots[i + 1] = True
                durability[i + 1] -= 1

        # 내리는 위치에 로봇이 도달하면 내림
        if robots[N - 1]:
            robots[N - 1] = False

        # 3. 올리는 위치에 로봇 올리기
        if durability[0] > 0:
            robots[0] = True
            durability[0] -= 1

        # 4. 내구도가 0인 칸의 개수 세기
        if durability.count(0) >= K:
            break

    return step

# 입력 받기
N, K = map(int, input().split())
durability = list(map(int, input().split()))

# 결과 출력
print(simulate_conveyor_belt(N, K, durability))
