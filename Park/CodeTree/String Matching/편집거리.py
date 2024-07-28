str1 = input()
str2 = input()

str1_len, str2_len = len(str1), len(str2)

# 인덱스를 1부터 시작하게 하기 위해 앞에 '#' 추가
str1, str2 = '#' + str1, '#' + str2

# dp 테이블 초기화
dp = [[0] * (str2_len + 1) for _ in range(str1_len + 1)]

def initialize():
    # 초기 상태 설정
    for i in range(1, str1_len + 1):
        dp[i][0] = i
    for j in range(1, str2_len + 1):
        dp[0][j] = j

initialize()

for i in range(1, str1_len + 1):
    for j in range(1, str2_len + 1):
        # 문자가 같으면 편집 거리 유지
        if str1[i] == str2[j]:
            dp[i][j] = dp[i-1][j-1]
        # 문자가 다르면 편집 거리 증가
        else:
            dp[i][j] = min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]) + 1

print(dp[str1_len][str2_len])
