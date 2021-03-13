data = input()
row = int(data[1])
column = ord(data[0]) - ord('a') + 1

path = [(-2, 1), (2, 1), (2, -1), (-2, -1), (1, 2), (-1, 2), (1, -2), (-1, -2)]

count = 0
for step in path:
    next_row = row + step[0]
    next_column = column + step[1]

    if 8 >= next_row >= 1 and 8 >= next_column >= 1:
        count += 1

print(count)
