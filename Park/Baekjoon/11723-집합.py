import sys

# 입력의 수가 많으므로, 빠른 입출력을 위해 sys.stdin과 sys.stdout을 사용
input = sys.stdin.read
output = sys.stdout.write

def main():
    input_data = input().split()
    M = int(input_data[0])
    operations = input_data[1:]
    
    S = set()  # 공집합
    
    result = []
    idx = 0
    for _ in range(M):
        operation = operations[idx]
        if operation == 'add':
            x = int(operations[idx + 1])
            S.add(x)
            idx += 2
        elif operation == 'remove':
            x = int(operations[idx + 1])
            S.discard(x)  # discard는 존재하지 않아도 오류가 발생하지 않음
            idx += 2
        elif operation == 'check':
            x = int(operations[idx + 1])
            result.append('1\n' if x in S else '0\n')
            idx += 2
        elif operation == 'toggle':
            x = int(operations[idx + 1])
            if x in S:
                S.remove(x)
            else:
                S.add(x)
            idx += 2
        elif operation == 'all':
            S = set(range(1, 21))
            idx += 1
        elif operation == 'empty':
            S = set()
            idx += 1
    
    output(''.join(result))

if __name__ == '__main__':
    main()
