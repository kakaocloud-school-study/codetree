# 스위치 상태 변경 함수
def toggle_switch(switches, idx):
    switches[idx] = 1 - switches[idx]  # 0은 1로, 1은 0으로 변경

# 입력 받기
n = int(input())  # 스위치 개수
switches = list(map(int, input().split()))  # 스위치 상태
student_count = int(input())  # 학생 수

# 각 학생의 조작을 처리
for _ in range(student_count):
    gender, num = map(int, input().split())
    
    if gender == 1:  # 남학생인 경우
        for i in range(num-1, n, num):
            toggle_switch(switches, i)
    elif gender == 2:  # 여학생인 경우
        toggle_switch(switches, num-1)
        left = num-2
        right = num
        while left >= 0 and right < n and switches[left] == switches[right]:
            toggle_switch(switches, left)
            toggle_switch(switches, right)
            left -= 1
            right += 1

# 결과 출력
for i in range(0, n, 20):  # 20개씩 출력
    print(' '.join(map(str, switches[i:i+20])))
