# 분해 합 구하기
n = int(input())

flag = 0
result = 0
for i in range(1, n):
    if n == i + sum(list(map(int, str(i)))):
        print(i)
        flag = 1
        break

if flag == 0:
    print(0)


