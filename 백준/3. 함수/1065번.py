def myfunction(a):
    differ = a[1] - a[0]
    for i in range(len(a) - 1, 0, -1):
        if a[i] - a[i - 1] != differ:
            return 0
    return 1


n = int(input())

count = 0
for i in range(1, n + 1):
    if i < 10:
        count += 1
        continue

    if myfunction(list(map(int, str(i)))) == 1:
        count += 1

print(count)
