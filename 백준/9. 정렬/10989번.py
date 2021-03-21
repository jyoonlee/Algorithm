# 메모리, 시간 다 맞아야함 타이트해

import sys
T = int(sys.stdin.readline())

li = [0 for i in range(10000)]

# 앞의 리스트 인덱스가 숫자고 이제 카운팅할꺼야
for _ in range(T):
    x = int(sys.stdin.readline())
    li[x-1] += 1


for index, value in enumerate(li):
    if value != 0:
        for i in range(value):
            sys.stdout.write('{}\n'.format(index+1))