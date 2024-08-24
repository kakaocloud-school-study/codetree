# 사람 수 N 입력
N = int(input())

# 자신보다 큰 사람이 왼쪽에 몇 명 있는지에 대한 정보 입력
left_larger_count = list(map(int, input().split()))

# 최종 줄을 저장할 리스트
lineup = [0] * N

# 1번 사람부터 N번 사람까지 차례대로 줄을 세움
for i in range(N):
    count = left_larger_count[i]
    # 빈 자리 중에서 count만큼 지나서 사람을 배치
    for j in range(N):
        if lineup[j] == 0:  # 빈 자리
            if count == 0:
                lineup[j] = i + 1  # 키가 i + 1인 사람을 배치
                break
            else:
                count -= 1

# 결과 출력
print(' '.join(map(str, lineup)))
