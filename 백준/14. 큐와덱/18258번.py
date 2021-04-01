# 큐 구현

import sys
from collections import deque

input = sys.stdin.readline

n = int(input())

queue = deque([])
for _ in range(n):
    temp = input().split()

    if temp[0] == 'push':
        queue.append(temp[1])

    elif temp[0] == 'front':
        if len(queue) == 0:
            print(-1)
        else:
            print(queue[0])

    elif temp[0] == 'back':
        if len(queue) == 0:
            print(-1)
        else:
            print(queue[-1])

    elif temp[0] == 'size':
        print(len(queue))

    elif temp[0] == 'empty':
        if len(queue) == 0:
            print(1)
        else:
            print(0)

    elif temp[0] == 'pop':
        if len(queue) == 0:
            print(-1)
        else:
            print(queue[0])
            queue.popleft()
