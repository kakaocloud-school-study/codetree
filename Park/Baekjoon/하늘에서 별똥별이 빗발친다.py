def solve():
    N, M, L, K = map(int, input().split())
    stars = [tuple(map(int, input().split())) for _ in range(K)]
    
    max_covered = 0
    
    # 모든 별똥별을 왼쪽 위 모서리로 고려하여 트램펄린 배치
    for i in range(K):
        for j in range(K):
            x1 = stars[i][0]
            y1 = stars[j][1]
            x2 = x1 + L
            y2 = y1 + L
            
            # x1, y1을 왼쪽 위 모서리로 하는 트램펄린이 커버하는 별똥별의 수 계산
            count = 0
            for x, y in stars:
                if x1 <= x <= x2 and y1 <= y <= y2:
                    count += 1
            
            # 최댓값 갱신
            max_covered = max(max_covered, count)
    
    # 트램펄린이 튕겨내지 못한 별똥별의 수
    result = K - max_covered
    print(result)

