a, b = map(int, input().split())
n = list(input().split())

for i in n:
    if b > int(i):
        print(i, end=" ")