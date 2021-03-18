a = int(input())
b = int(input())
c = int(input())

mul = a * b * c
result = list(str(mul))
count_array = [0 for i in range(10)]

for i in result:
    count_array[int(i)] += 1

for count in count_array:
    print(count)

#
# a = int(input())
# b = int(input())
# c = int(input())
#
# array = list(map(int, (str(a * b * c))))
#
# for i in range(10):
#     print(array.count(i))
