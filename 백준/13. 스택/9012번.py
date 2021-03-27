# 괄호 문자열

import sys

input = sys.stdin.readline

T = int(input())


for _ in range(T):
    stack = []
    li = list(input().rstrip())
    result = 1

    for i in li:
        if i != ')':
            stack.append(i)
        else:
            if len(stack) != 0:
                stack.pop()
            else:
                result = 0

    if len(stack) == 0 and result == 1:
        print('YES')
    else:
        print('NO')