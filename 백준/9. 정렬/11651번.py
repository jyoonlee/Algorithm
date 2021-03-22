# 입력 받아서 정렬하기

N = int(input())
value = []

for _ in range(N):
    x, y = map(int, input().split())
    value.append([y,x])

value = sorted(value)

for i in value:
    print("{} {}".format(i[1], i[0]))