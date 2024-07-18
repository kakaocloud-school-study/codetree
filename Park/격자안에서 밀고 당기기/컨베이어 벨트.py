# 입력을 받습니다.
n, t = map(int, input().split())
u = list(map(int, input().split()))
d = list(map(int, input().split()))

# t초 동안 회전합니다.
for _ in range(t):
    # 위의 오른쪽 끝 숫자를 저장합니다.
    temp = u[-1]
    
    # 위의 숫자들을 오른쪽으로 한 칸씩 이동합니다.
    for i in range(n-1, 0, -1):
        u[i] = u[i-1]
    # 아래의 오른쪽 끝 숫자를 위의 왼쪽 끝으로 이동합니다.
    u[0] = d[-1]
    
    # 아래의 숫자들을 오른쪽으로 한 칸씩 이동합니다.
    for i in range(n-1, 0, -1):
        d[i] = d[i-1]
    # temp에 저장한 위의 오른쪽 끝 숫자를 아래의 왼쪽 끝으로 이동합니다.
    d[0] = temp

# 결과를 출력합니다.
print(' '.join(map(str, u)))
print(' '.join(map(str, d)))
