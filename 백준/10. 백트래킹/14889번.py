# 축구 팀 짜기
# 행렬이 주어졌을 때 능력치 합산에 맞게 팀 분배

n = int(input())
li = [list(map(int, input().split())) for _ in range(n)]
check = []
result = []


def op(a):
    if len(check) == n / 2:
        enemy = []
        for z in range(len(li)):
            if z not in check:
                enemy.append(z)

        value1 = 0
        value2 = 0
        for i in check:
            for j in check:
                value1 += li[i][j]

        for i in enemy:
            for j in enemy:
                value2 += li[i][j]

        result.append(abs(value1 - value2))

    for i in range(a, n):
        if i not in check:
            check.append(i)
            op(i + 1)
            check.pop()


op(0)
print(min(result))
