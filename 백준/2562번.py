array = []
for i in range(9):
    array.append(int(input()))

print(max(array))
print(array.index(max(array)))  # 리스트 내에서 최대값의 인덱스 위치 