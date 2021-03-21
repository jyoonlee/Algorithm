# 상근이의 할머니 전화 다이얼 돌리기

char_number = list(input())

number = [[], ['A', 'B', 'C'], ['D', 'E', 'F'], ['G', 'H', 'I'], ['J', 'K', 'L'], ['M', 'N', 'O']
    , ['P', 'Q', 'R', 'S'], ['T', 'U', 'V'], ['W', 'X', 'Y', 'Z'], []]

total = 0
for i in char_number:
    for j in number:
        if i in j:
            total += 2 + number.index(j)

print(total)

