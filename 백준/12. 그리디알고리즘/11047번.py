# 동전 문제

import sys

N, K = map(int, sys.stdin.readline().split())
li = []
for _ in range(N):
    li.append(int(sys.stdin.readline()))

count = 0
for i in range(len(li)-1, -1, -1):
    if K < li[i]:
        continue
    else:
        count += K // li[i]
        K -= li[i] * (K // li[i])

print(count)