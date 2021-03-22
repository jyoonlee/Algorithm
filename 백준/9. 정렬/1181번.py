# 단어가 주어졌을 때 길이로 sorting 하고 길이가 같으면 사전순으로 다시 sorting

value = [input() for _ in range(int(input()))]
sorted_value = sorted(value, key=lambda x: (len(x), x))
print('\n'.join(x for x in sorted_value))



# 시간 초과
# value = []
# for _ in range(N):
#     value.append(input())
#
# for word in value:
#     if value.count(word) > 1:
#         value.remove(word)
#
#
# temp = ""
# re = []
# for i in range(len(value)):
#     for j in range(i, len(value)):
#         if len(value[i]) > len(value[j]):
#             temp = value[j]
#             value[j] = value[i]
#             value[i] = temp
#         elif len(value[i]) == len(value[j]):
#             if value[i] > value[j]:
#                 temp = value[j]
#                 value[j] = value[i]
#                 value[i] = temp
#
# print('\n'.join(x for x in value))
#
