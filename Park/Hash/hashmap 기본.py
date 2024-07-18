def process_commands(n, commands):
    hashmap = {}  # hashmap 초기화
    results = []  # 결과를 저장할 리스트 초기화

    for command in commands:
        parts = command.split()
        cmd = parts[0]
        key = int(parts[1])

        if cmd == "add":
            value = int(parts[2])
            hashmap[key] = value  # (key, value) 쌍을 hashmap에 추가
        elif cmd == "remove":
            if key in hashmap:
                del hashmap[key]  # key가 k인 쌍을 hashmap에서 제거
        elif cmd == "find":
            if key in hashmap:
                results.append(hashmap[key])  # key가 존재하면 value를 출력
            else:
                results.append(None)  # key가 존재하지 않으면 None 출력

    return results

# 입력 예제
n = 11
commands = [
    "add 3 5",
    "add 10000 1",
    "find 3",
    "find 5",
    "find 10000",
    "add 3 10",
    "find 3",
    "add 7 15",
    "remove 3",
    "remove 7",
    "find 7"
]

# 명령 처리 및 결과 출력
results = process_commands(n, commands)
for result in results:
    print(result)
