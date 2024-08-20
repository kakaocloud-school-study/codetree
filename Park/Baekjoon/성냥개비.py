def solve():
    # 각 테스트 케이스에 대한 성냥개비의 개수를 저장
    matchsticks_for_min = {2: '1', 3: '7', 4: '4', 5: '2', 6: '6', 7: '8'}
    
    # 첫째 줄에 테스트 케이스의 개수를 입력받음
    t = int(input())
    
    # 각 테스트 케이스 별로 처리
    for _ in range(t):
        n = int(input())
        
        # 최소 숫자 찾기
        # 성냥개비가 2에서 7개일 때는 미리 계산한 값을 사용
        if n in matchsticks_for_min:
            min_num = matchsticks_for_min[n]
        else:
            # 짝수 개일 때는 모두 1로 만들 수 있음 (예: 8개 -> 10)
            if n % 2 == 0:
                min_num = '1' * (n // 2)
            else:
                # 홀수 개일 때는 첫번째 자리를 7로 하고 나머지는 1로 채움
                min_num = '7' + '1' * ((n - 3) // 2)
        
        # 최대 숫자 찾기
        # 최대 숫자는 모두 1로 채우면 됨
        if n % 2 == 0:
            max_num = '1' * (n // 2)
        else:
            max_num = '7' + '1' * ((n - 3) // 2)
        
        # 결과 출력
        print(min_num, max_num)

