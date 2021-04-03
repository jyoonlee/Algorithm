import sys
from collections import deque

n, k = map(int, input().split())

queue = deque([x for x in range(1,n+1)])
li = []

count = 1
while len(queue) != 0:
    if count != k:
        queue.append(queue.popleft())
        count += 1
    else:
        li.append(queue.popleft())
        print(queue)
        count = 0

print(li)



