# 스택 구현
import sys

li = []


def stack(s):
    if 'push' in s:
        push = s.split(' ')
        li.append(int(push[1]))
    elif 'size' in s:
        print(len(li))
    elif 'top' in s:
        if len(li) == 0:
            print(-1)
        else:
            print(li[len(li) - 1])
    elif 'empty' in s:
        if len(li) == 0:
            print(1)
        else:
            print(0)
    elif 'pop' in s:
        if len(li) == 0:
            print(-1)
        else:
            print(li[len(li)-1])
            li.pop()


input = sys.stdin.readline
N = int(input())

for _ in range(N):
    stack(input())
