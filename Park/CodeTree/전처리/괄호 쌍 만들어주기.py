# 문자열 입력받기 및 초기 설정
string = input()
n = len(string)
R = [0] * n  # i 이후에 나올 수 있는 연속된 ))의 수를 저장할 배열

# 뒤에서부터 연속된 )) 조합을 계산
R[n - 1] = 0  # 마지막 문자는 혼자라서 조합을 만들 수 없음
for i in range(n - 2, -1, -1):
    if string[i] == ')' and string[i + 1] == ')':  # 연속된 )) 발견 시
        R[i] = R[i + 1] + 1  # 이전에 계산된 값에서 1 더하기
    else:
        R[i] = R[i + 1]  # 아니면 그냥 이전 값 유지

# 앞에서부터 연속된 (( 조합을 찾아서 대응되는 ))의 개수를 더하기
ans = 0
for i in range(n - 2):
    if string[i] == '(' and string[i + 1] == '(':  # 연속된 (( 발견 시
        ans += R[i + 2]  # 그 뒤에 나올 수 있는 ))의 개수 더하기

# 최종 결과 출력
print(ans)
