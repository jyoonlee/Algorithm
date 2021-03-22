# 입력 받아서 정렬하기

N = int(input())
value = []

for _ in range(N):
    x, y = map(int, input().split())
    value.append([y, x])

value = sorted(value)

for i in value:
    print("{} {}".format(i[1], i[0]))

# import sys
#
# number = int(input())
# position_list = []
#
# for _ in range(number):
#     position_list.append(tuple(map(int,sys.stdin.readline().split())))
#
# position_list.sort(key = lambda x:(x[1],x[0]))
#
# for item in position_list:
#     sys.stdout.write(str(item[0])+" "+str(item[1])+"\n")
