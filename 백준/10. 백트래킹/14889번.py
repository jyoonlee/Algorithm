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

        print(check)
        print(enemy)

        value1 = 0
        value2 = 0
        for i in check:
            for j in check:
                if i != j:
                    value1 += li[i][j] + li[j][i]

        for i in enemy:
            for j in enemy:
                if i != j:
                    value2 += li[i][j] + li[j][i]

        result.append(abs(value1 - value2))

    for i in range(a, n):
        if i not in check:
            check.append(i)
            op(i+1)
            check.pop()

op(0)
print(result)
print(min(result))
#
# for i in range(a, n):
#     for j in range(b, n):
#         if i == j:
#             continue
#         else:
#             if i not in check and j not in check:
#                 check.append(i)
#                 print(check)
#                 op(i + 1, j + 1)
#                 check.pop()
