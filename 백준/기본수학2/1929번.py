M, N = map(int,input().split())

value = [x for x in range(M, N+1)]

if 1 in value:
    value.remove(1)

for i in range(2, N+1):
    for j in value:
        if j % i == 0 and i != j:
            value.remove(j)

if len(value) == 0 or N == 1:
    print("-1")
else:
    print(sum(value))
    print(min(value))

