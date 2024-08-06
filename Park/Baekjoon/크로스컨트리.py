def find_winning_team(test_cases):
    results = []
    
    for case in test_cases:
        N, team_numbers = case
        team_scores = {}
        team_positions = {}
        
        # 각 팀별 선수의 순위 기록
        for i in range(N):
            team = team_numbers[i]
            if team not in team_scores:
                team_scores[team] = []
                team_positions[team] = 0
            team_scores[team].append(i + 1)
            team_positions[team] += 1
        
        # 팀별 6명 이상 참가 확인 및 점수 계산
        valid_teams = {team: sorted(positions[:5]) for team, positions in team_scores.items() if team_positions[team] >= 6}
        
        if not valid_teams:
            continue
        
        min_score = float('inf')
        winning_team = -1
        for team, positions in valid_teams.items():
            score = sum(positions[:4])
            if score < min_score or (score == min_score and positions[4] < valid_teams[winning_team][4]):
                min_score = score
                winning_team = team
        
        results.append(winning_team)
    
    return results

# 표준 입력을 받는 부분
import sys
input = sys.stdin.read
data = input().split()

# 데이터 파싱
T = int(data[0])
index = 1
test_cases = []

for _ in range(T):
    N = int(data[index])
    team_numbers = list(map(int, data[index + 1:index + 1 + N]))
    test_cases.append((N, team_numbers))
    index += N + 1

# 결과 출력
results = find_winning_team(test_cases)
for result in results:
    print(result)
