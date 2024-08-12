# 주석과 함께 작성된 코드

def dfs(graph, start, visited):
    stack = [start]  # DFS를 위한 스택 초기화
    visited[start] = True  # 시작 컴퓨터 방문 기록
    count = 0  # 웜 바이러스에 걸린 컴퓨터 수

    while stack:
        node = stack.pop()  # 스택에서 컴퓨터 하나를 꺼내기
        count += 1  # 방문했으므로 카운트 증가
        for neighbor in graph[node]:  # 인접한 모든 컴퓨터에 대해
            if not visited[neighbor]:  # 방문하지 않았다면
                stack.append(neighbor)  # 스택에 추가
                visited[neighbor] = True  # 방문 기록

    return count - 1  # 시작 컴퓨터는 제외해야 하므로 -1

def main():
    import sys
    input = sys.stdin.read
    data = input().split()
    
    num_computers = int(data[0])  # 컴퓨터의 수
    num_pairs = int(data[1])  # 네트워크 상 연결된 컴퓨터 쌍의 수
    
    graph = [[] for _ in range(num_computers + 1)]  # 인접 리스트 초기화
    visited = [False] * (num_computers + 1)  # 방문 기록 초기화
    
    index = 2
    for _ in range(num_pairs):
        a = int(data[index])
        b = int(data[index + 1])
        graph[a].append(b)  # 양방향 연결
        graph[b].append(a)  # 양방향 연결
        index += 2
    
    result = dfs(graph, 1, visited)  # 1번 컴퓨터에서 시작하여 DFS 수행
    print(result)  # 결과 출력

if __name__ == "__main__":
    main()
