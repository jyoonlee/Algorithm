N = int(input())

li = []

for _ in range(N):
    li.append(list(map(int, input().split())))


temp = [1 for _ in range(len(li))]

for i in range(len(li)):
    for j in range(len(li)):

        if li[i][0] < li[j][0] and li[i][1] < li[j][1]:
            temp[i] += 1

print(" ".join(str(item) for item in temp))
