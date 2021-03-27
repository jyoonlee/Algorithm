# 식이 주어졌을 때 적절히 괄호쳐서 최소값 구하기

import sys
input = sys.stdin.readline

plus = input().split('-')
re = 0  # 총 합

# 초반에 플러스가 많이 올 경우 모두 합산
for i in plus[0].split('+'):
    re += int(i)

for k in plus[1:]:
    for j in k.split('+'):
        re -= int(j)

print(re)
