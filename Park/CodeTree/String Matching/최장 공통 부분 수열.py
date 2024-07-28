str1 = input()
str2 = input()

str1_len, str2_len = len(str1), len(str2)

# 인덱스를 1부터 시작하게 하기 위해 앞에 '#' 추가
str1, str2 = '#' + str1, '#' + str2

# dp 테이블 초기화
dp = [[0] * (str2_len + 1) for _ in range(str1_len + 1)]

def initialize():
    # 첫 번째 문자의 초기값 설정
    dp[1][1] = int(str1[1] == str2[1])
    
    # 첫 번째 문자열의 첫 문자와 비교하여 초기값 설정
    for i in range(2, str1_len + 1):
        dp[i][1] = 1 if str1[i] == str2[1] else dp[i-1][1]
    
    # 두 번째 문자열의 첫 문자와 비교하여 초기값 설정
    for j in range(2, str2_len + 1):
        dp[1][j] = 1 if str1[1] == str2[j] else dp[1][j-1]

initialize()

for i in range(2, str1_len + 1):
    for j in range(2, str2_len + 1):
        # 문자가 같으면 이전 dp 값에 1을 더함
        if str1[i] == str2[j]:
            dp[i][j] = dp[i-1][j-1] + 1
        # 문자가 다르면 이전 dp 값 중 큰 값을 사용
        else:
            dp[i][j] = max(dp[i-1][j], dp[i][j-1])

print(dp[str1_len][str2_len])
