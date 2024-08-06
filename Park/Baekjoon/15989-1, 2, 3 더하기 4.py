def count_ways(n):
    dp = [0] * (n + 1)
    dp[0] = 1  # 합이 0을 만드는 경우는 아무것도 더하지 않는 경우 1가지

    for i in range(1, n + 1):
        if i - 1 >= 0:
            dp[i] += dp[i - 1]
        if i - 2 >= 0:
            dp[i] += dp[i - 2]
        if i - 3 >= 0:
            dp[i] += dp[i - 3]
    
    return dp[n]

def main():
    import sys
    input = sys.stdin.read
    data = input().split()
    T = int(data[0])
    test_cases = [int(data[i]) for i in range(1, T + 1)]

    max_n = max(test_cases)
    dp = [0] * (max_n + 1)
    dp[0] = 1

    for i in range(1, max_n + 1):
        if i - 1 >= 0:
            dp[i] += dp[i - 1]
        if i - 2 >= 0:
            dp[i] += dp[i - 2]
        if i - 3 >= 0:
            dp[i] += dp[i - 3]

    results = [dp[tc] for tc in test_cases]
    
    for result in results:
        print(result)

if __name__ == "__main__":
    main()
