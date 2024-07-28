n = int(input("숫자를 입력하세요: "))  # 사용자로부터 입력을 받음

def fib(n):
    if n == 1 or n == 2:  # n이 1 또는 2일 때
        return 1
    
    # 재귀적으로 피보나치 수를 계산
    return fib(n - 1) + fib(n - 2)

print(fib(n))  # 결과 출력
