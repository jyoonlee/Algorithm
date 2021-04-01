import sys
from collections import deque

input = sys.stdin.readline

n = int(input())

queue = deque([x for x in range(1, n+1)])

while len(queue) != 1:
    queue.popleft()
    queue.append(queue[0])
    queue.popleft()

print(queue[0])
