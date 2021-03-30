# 오큰수

import sys

input = sys.stdin.readline

n = int(input())
li = list(map(int, input().split()))
result = []

for i in range(n):
    while result and li[result[-1]] < li[i]:
        li[result[-1]] = li[i]
        result.pop()
    result.append(i)

while result:
    li[result[-1]] = -1
    result.pop()

for i in li:
    print(i, end=' ')




# 시간 초과
# def stack(i):
#     big = []
#     for j in range(i + 1, n):
#         if li[i] < li[j]:
#             big.append(li[j])
#
#     if big:
#         result.append(min(big))
#     else:
#         result.append(-1)
#
#
# for i in range(n):
#     stack(i)
#
# print(" ".join(str(x) for x in result))