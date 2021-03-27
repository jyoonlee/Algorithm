# pop 했다가 스택 내 모든 수 합

import sys
input = sys.stdin.readline

K = int(input())

li = []
for _ in range(K):
    num = int(input())
    if num != 0:
        li.append(num)
    else:
        li.pop()

print(sum(li))
