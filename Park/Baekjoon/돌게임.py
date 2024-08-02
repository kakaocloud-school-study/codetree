def stone_game(N):
    # N이 홀수이면 상근이가 이김
    if N % 2 == 1:
        return "SK"
    # N이 짝수이면 창영이가 이김
    else:
        return "CY"

# 입력 값을 받아서 처리
N = int(input())
print(stone_game(N))