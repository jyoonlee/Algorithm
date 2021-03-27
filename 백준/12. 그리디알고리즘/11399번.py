# 은행 줄 세우기

import sys

N = int(sys.stdin.readline())
li = list((map(int, sys.stdin.readline().split())))

ans = sorted(li)

total = 0
for i in range(len(ans)):
    total += ans[i]*(len(ans)-i)

print(total)