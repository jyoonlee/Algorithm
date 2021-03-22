N = int(input())

value = []
for _ in range(N):
    value.append(input())


temp = ""
for i in range(N):
    for j in range(i, N):
        if len(value[i]) > len(value[j]):
            temp = value[j]
            value[j] = value[i]
            value[i] = temp
        elif len(value[i]) == len(value[j]):
            if value[i] >= value[j]:
                temp = value[j]
                value[j] = value[i]
                value[i] = temp

print('\n'.join(x for x in value))

