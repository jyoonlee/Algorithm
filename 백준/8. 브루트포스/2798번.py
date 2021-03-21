# 블랙잭 게임

N, M = map(int, input().split())
number = list(map(int, input().split()))

diff = 300001
result = 0
for i in range(len(number)):
    for j in range(i+1, len(number)):
        for z in range(j+1, len(number)):
            total = number[i] + number[j] + number[z]
            if total <= M and diff > abs(M - total):
                diff = abs(M - total)
                result = total

print(result)
