# 별 찍기 문제 (실버1)
# https://www.acmicpc.net/problem/2447
# "".join(배열) 형태 꼭 쓰기 => 시간 절약

import sys

def star(n, m):
    while n != 0:
        if n % 3 == 1 and m % 3 == 1:
            sys.stdout.write(' ')
            return None

        n = n // 3
        m = m // 3
    sys.stdout.write("*")


n = int(input())

for i in range(n):
    for j in range(n):
        star(i, j)
    sys.stdout.write('\n')




