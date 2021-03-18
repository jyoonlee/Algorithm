n = int(input())
array = [int(i) for i in input().split()]

min_value = min(array)
max_value = max(array)

print("{} {}".format(min_value, max_value))
