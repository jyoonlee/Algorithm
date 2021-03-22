# 입력 받아서 정렬하기

N = int(input())
value = []

for _ in range(N):
    value.append(list(map(int, input().split())))


value.sort()

# 시간 초과 
# temp = []
# for i in range(N):
#     for j in range(i+1, N):
#         if value[i][0] > value[j][0]:
#             temp = value[i]
#             value[i] = value[j]
#             value[j] = temp
#
#         elif value[i][0] == value[j][0]:
#             if value[i][1] > value[j][1]:
#                 value[i] = value[j]
#                 value[j] = temp

for i in value:
    print("{} {}".format(i[0], i[1]))


