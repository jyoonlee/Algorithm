T = int(input())

value = list(map(int, input().split()))

if 1 in value:
    value.remove(1)

for i in range(2, 1001):
    for j in value:
        if j % i == 0 and i != j:
            value.remove(j)

print(len(value))
