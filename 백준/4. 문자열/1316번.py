# 그룹 단어 체커

n = int(input())

count = 0
for _ in range(n):
    flag = 1
    word = input()

    result = ""
    for i in word:
        if i not in result:
            result += i
        elif i != result[-1]:
            flag = 0
            continue

    if flag == 1:
        count += 1

print(count)
