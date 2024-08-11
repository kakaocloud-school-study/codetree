def calculate_rank(test_cases):
    for case in test_cases:
        n, k, t, m, logs = case['n'], case['k'], case['t'], case['m'], case['logs']
        
        # 각 팀에 대해 점수와 제출 횟수를 기록할 딕셔너리
        scores = {i: [0] * k for i in range(1, n+1)}
        attempts = {i: 0 for i in range(1, n+1)}
        last_submission = {i: 0 for i in range(1, n+1)}
        
        # 로그를 순서대로 처리
        for time, (team_id, problem_id, score) in enumerate(logs, 1):
            problem_idx = problem_id - 1
            if score > scores[team_id][problem_idx]:
                scores[team_id][problem_idx] = score
            attempts[team_id] += 1
            last_submission[team_id] = time
        
        # 각 팀의 총점 계산
        final_scores = []
        for team_id in range(1, n+1):
            total_score = sum(scores[team_id])
            final_scores.append((total_score, attempts[team_id], last_submission[team_id], team_id))
        
        # 최종 정렬: 총점 내림차순 -> 제출 횟수 오름차순 -> 마지막 제출 시간 오름차순
        final_scores.sort(key=lambda x: (-x[0], x[1], x[2]))
        
        # 팀 t의 순위 찾기
        for rank, (score, attempts, last_time, team_id) in enumerate(final_scores, 1):
            if team_id == t:
                print(rank)
                break

# 입력 받기
T = int(input())
test_cases = []
for _ in range(T):
    n, k, t, m = map(int, input().split())
    logs = [tuple(map(int, input().split())) for _ in range(m)]
    test_cases.append({'n': n, 'k': k, 't': t, 'm': m, 'logs': logs})

# 순위 계산 및 출력
calculate_rank(test_cases)
