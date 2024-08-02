def calculate_rank(N, new_score, P, scores):
    # 점수 리스트가 비어있는 경우, 태수의 점수가 1등.
    if N == 0:
        return 1

    # 현재 랭킹 리스트가 꽉 차있고, 새로운 점수가 마지막 점수보다 작거나 같다면 -1
    if N == P and new_score <= scores[-1]:
        return -1

    # 새로운 점수의 등수를 계산.
    rank = 1
    for score in scores:
        if new_score < score:
            rank += 1
        else:
            break

    # 랭킹 리스트가 꽉 차있지 않은 경우
    if N < P:
        return rank
    # 랭킹 리스트가 꽉 차있지만 새로운 점수가 더 좋은 경우
    elif new_score > scores[-1]:
        return rank

# 입력값 받기
N, new_score, P = map(int, input().split())
if N > 0:
    scores = list(map(int, input().split()))
else:
    scores = []

# 결과 출력
print(calculate_rank(N, new_score, P, scores))
