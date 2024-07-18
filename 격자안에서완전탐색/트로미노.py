def max_block_sum(n, m, grid):
    # 블록의 모든 회전 및 뒤집기 상태
    blocks = [
        # 첫 번째 블록 (L자 모양)
        [(1, 1), (1, 0), (1, 0)],
        [(1, 1), (0, 1), (0, 1)],
        [(1, 1, 1), (1, 0, 0)],
        [(1, 1, 1), (0, 0, 1)],
        [(1, 0, 0), (1, 1, 1)],
        [(0, 0, 1), (1, 1, 1)],
        [(0, 1, 1), (1, 1)],
        [(1, 1, 0), (0, 1, 1)],
        # 두 번째 블록 (일자 모양)
        [(1, 1, 1, 1)],
        [(1,), (1,), (1,), (1,)]
    ]
    
    max_sum = 0
    
    for block in blocks:
        block_height = len(block)  # 블록의 높이
        block_width = len(block[0])  # 블록의 너비
        
        for i in range(n - block_height + 1):  # 블록을 놓을 수 있는 행의 범위
            for j in range(m - block_width + 1):  # 블록을 놓을 수 있는 열의 범위
                current_sum = 0  # 현재 위치에서 블록이 덮는 칸의 합
                
                for bi in range(block_height):  # 블록의 행을 순회
                    for bj in range(block_width):  # 블록의 열을 순회
                        if block[bi][bj] == 1:  # 블록이 덮는 부분만 합산
                            current_sum += grid[i + bi][j + bj]
                
                max_sum = max(max_sum, current_sum)  # 최대 합 갱신
    
    return max_sum

# 입력 받기
def main():
    n, m = map(int, input().split())  # 첫 번째 줄에서 n과 m을 입력 받음
    grid = [list(map(int, input().split())) for _ in range(n)]  # n개의 행을 입력 받아 2차원 리스트로 저장
    
    # 최대 블록 합 계산 및 출력
    print(max_block_sum(n, m, grid))

# 메인 함수 실행
if __name__ == "__main__":
    main()
