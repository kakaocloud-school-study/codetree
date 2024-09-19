# 변수 선언 및 입력
n = int(input())
a = input()
b = input()

# 처음 미스매치 횟수 계산
mismatch_count = 0
in_mismatch = False

for i in range(n):
    if a[i] != b[i]:
        # 미스매치가 처음 발생하면 카운트 증가
        if not in_mismatch:
            mismatch_count += 1
            in_mismatch = True
    else:
        # 미스매치가 끝난 경우
        in_mismatch = False

print(mismatch_count)
