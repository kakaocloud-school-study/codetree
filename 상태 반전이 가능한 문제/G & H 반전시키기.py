def min_flips(N, initial, target):
    # 초기값 설정
    flip_count = 0
    i = 0
    
    while i < N:
        # 만약 현재 문자가 다르다면, 구간을 찾기 시작
        if initial[i] != target[i]:
            # 연속된 다른 부분을 찾기 위해 루프 시작
            while i < N and initial[i] != target[i]:
                i += 1
            # 연속된 다른 부분을 하나 찾았으므로 flip_count 증가
            flip_count += 1
        else:
            i += 1
    
    return flip_count

# 입력 받기
N = int(input())
initial = input().strip()
target = input().strip()

# 결과 출력
print(min_flips(N, initial, target))
