def min_moves_to_group_balls(n, balls):
    # 연속된 빨간색 덩어리 개수와 파란색 덩어리 개수를 계산
    red_segments = 0
    blue_segments = 0
    
    # 첫 번째 볼 색을 기준으로 첫 번째 덩어리 색을 결정
    current_color = balls[0]
    
    # 첫 번째 덩어리의 색을 증가
    if current_color == 'R':
        red_segments += 1
    else:
        blue_segments += 1
    
    # 두 번째 볼부터 확인하여 색이 바뀔 때 덩어리 개수를 증가시킴
    for i in range(1, n):
        if balls[i] != current_color:
            current_color = balls[i]
            if current_color == 'R':
                red_segments += 1
            else:
                blue_segments += 1
    
    # 최소 이동 횟수는 빨간색 덩어리로 모으거나 파란색 덩어리로 모으는 것 중 작은 값
    return min(red_segments, blue_segments)

# 입력 받기
n = int(input())
balls = input().strip()

# 결과 출력
print(min_moves_to_group_balls(n, balls))
