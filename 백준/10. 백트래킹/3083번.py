import copy

n = int(input())

_map = []
result = 0

for _ in range(n):
    _map.append(list(input()))


def switch_next(real, i, j):
    m = copy.deepcopy(real)

    max_value = 0
    count_a = 1
    count_b = 1
    count_c = 1
    count_d = 1
    temp = m[i][j]
    m[i][j] = m[i][j + 1]
    m[i][j + 1] = temp

    for z in range(n - 1):
        if m[i][z] == m[i][z + 1]:
            count_a += 1
        else:
            if max_value < count_a:
                max_value = count_a
            count_a = 1

        if m[z][j] == m[z + 1][j]:
            count_b += 1
        else:
            if max_value < count_b:
                max_value = count_b
            count_b = 1

        if i != n - 1 and j != n - 1:
            if m[i + 1][z] == m[i + 1][z + 1]:
                count_c += 1
            else:
                if max_value < count_c:
                    max_value = count_c
                count_c = 1

            if m[z][j + 1] == m[z + 1][j + 1]:
                count_d += 1
            else:
                if max_value < count_d:
                    max_value = count_d
                count_d = 1
    if z == n - 2:
        if max_value < max(count_a, count_b, count_c, count_d):
            max_value = max(count_a, count_b, count_c, count_d)

    return max_value


def switch_below(real, i, j):
    m = copy.deepcopy(real)

    max_value = 0
    count_a = 1
    count_b = 1
    count_c = 1
    count_d = 1

    temp = m[i][j]
    m[i][j] = m[i + 1][j]
    m[i + 1][j] = temp

    for z in range(n - 1):
        if m[i][z] == m[i][z + 1]:
            count_a += 1
        else:
            if max_value < count_a:
                max_value = count_a
            count_a = 1

        if m[z][j] == m[z + 1][j]:
            count_b += 1
        else:
            if max_value < count_b:
                max_value = count_b
            count_b = 1

        if i != n - 1 and j != n - 1:
            if m[i + 1][z] == m[i + 1][z + 1]:
                count_c += 1
            else:
                if max_value < count_c:
                    max_value = count_c
                count_c = 1

            if m[z][j + 1] == m[z + 1][j + 1]:
                count_d += 1
            else:
                if max_value < count_d:
                    max_value = count_d
                count_d = 1

    if z == n - 2:
        if max_value < max(count_a, count_b, count_c, count_d):
            max_value = max(count_a, count_b, count_c, count_d)

    return max_value


for i in range(n):
    for j in range(n):
        if i != n - 1 and j != n - 1:
            value1 = switch_next(_map, i, j)
            value2 = switch_below(_map, i, j)
            if result < max(value1, value2):
                result = max(value1, value2)
        elif i == n - 1 and j != n - 1:
            value2 = switch_next(_map, i, j)
            if result < value2:
                result = value2
        elif j == n - 1 and i != n - 1:
            value1 = switch_below(_map, i, j)
            if result < value1:
                result = value1

print(result)
