import heapq

def min_distance(N, D, shortcuts):
    # 초기 거리 설정
    distance = [i for i in range(D + 1)]
    
    # 지름길 정보 반영
    for start, end, dist in shortcuts:
        if end <= D and distance[end] > distance[start] + dist:
            distance[end] = distance[start] + dist
    
    # 다익스트라 알고리즘 적용
    for i in range(D + 1):
        if i > 0:
            distance[i] = min(distance[i], distance[i-1] + 1)
        
        for start, end, dist in shortcuts:
            if start == i and end <= D and distance[end] > distance[start] + dist:
                distance[end] = distance[start] + dist
    
    return distance[D]

# 입력 예제
N, D = 5, 150
shortcuts = [
    (0, 50, 10),
    (0, 50, 20),
    (50, 100, 10),
    (100, 151, 10),
    (110, 140, 90)
]

# 결과 출력
print(min_distance(N, D, shortcuts))  # 예제 1의 결과는 70
