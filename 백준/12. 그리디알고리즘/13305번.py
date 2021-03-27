# 주유소 문제
# https://www.acmicpc.net/problem/13305

import sys

input = sys.stdin.readline

N = int(input())

dis = list(map(int, input().split()))
cost = list(map(int, input().split()))

total = 0
now = cost[0]

for i in range(len(dis)):
    if now > cost[i]:
        now = cost[i]

    total += now * dis[i]

print(total)
