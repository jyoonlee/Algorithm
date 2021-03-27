# 회의실 배정 문제
import sys

N = int(sys.stdin.readline())
li = []
for _ in range(N):
    li.append(list(map(int, sys.stdin.readline().split())))

ans = sorted(li, key=lambda x: (x[1], x[0]))

count = 1
end = ans[0][1]

for i in range(0, len(ans)-1):
    if end <= ans[i+1][0]:
        count += 1
        end = ans[i+1][1]

print(count)

