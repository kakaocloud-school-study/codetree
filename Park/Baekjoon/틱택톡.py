def is_winner(board, player):
    # 승리 조건: 가로, 세로, 대각선 중 하나가 player로 3칸 연속 차있을 때
    win_patterns = [
        [0, 1, 2], [3, 4, 5], [6, 7, 8],  # 가로 승리 조건
        [0, 3, 6], [1, 4, 7], [2, 5, 8],  # 세로 승리 조건
        [0, 4, 8], [2, 4, 6]              # 대각선 승리 조건
    ]
    for pattern in win_patterns:
        if all(board[i] == player for i in pattern):
            return True
    return False

def is_valid_state(board):
    count_X = board.count('X')
    count_O = board.count('O')
    
    # 1. 'X'의 개수는 'O'의 개수보다 같거나 많아야 하며, 최대 1개 많을 수 있다.
    if not (count_X == count_O or count_X == count_O + 1):
        return False
    
    # 2. 승리 조건 확인
    X_wins = is_winner(board, 'X')
    O_wins = is_winner(board, 'O')
    
    # 'X'와 'O'가 동시에 이길 수 없다.
    if X_wins and O_wins:
        return False
    
    # 'X'가 이겼을 때는 'X'의 개수가 'O'보다 정확히 1개 많아야 한다.
    if X_wins and count_X != count_O + 1:
        return False
    
    # 'O'가 이겼을 때는 'X'의 개수가 'O'와 같아야 한다.
    if O_wins and count_X != count_O:
        return False
    
    # 3. 게임이 끝나는 조건은 게임판이 꽉 차거나, 승자가 있을 때
    if not X_wins and not O_wins and count_X + count_O != 9:
        return False
    
    return True

def main():
    import sys
    input = sys.stdin.read
    data = input().strip().split('\n')
    
    for board in data:
        if board == "end":
            break
        if is_valid_state(board):
            print("valid")
        else:
            print("invalid")

if __name__ == "__main__":
    main()
