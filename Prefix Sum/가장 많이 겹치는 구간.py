def find_max_overlapping_segments(n, segments):
    events = []
    
    # 시작점과 끝점을 이벤트로 추가
    for segment in segments:
        x1, x2 = segment
        events.append((x1, 1))  # 시작점 +1 이벤트
        events.append((x2, -1))  # 끝점 -1 이벤트
    
    # 이벤트를 x 좌표 기준으로 정렬
    events.sort()
    
    max_overlap = 0
    current_overlap = 0
    
    # 이벤트를 순차적으로 처리하며 현재 겹치는 구간의 수를 계산
    for event in events:
        x, value = event
        current_overlap += value
        if current_overlap > max_overlap:
            max_overlap = current_overlap
    
    return max_overlap

# 입력 받기
n = int(input())
segments = [tuple(map(int, input().split())) for _ in range(n)]

# 결과 출력
print(find_max_overlapping_segments(n, segments))
