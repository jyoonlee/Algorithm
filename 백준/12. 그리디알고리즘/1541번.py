
T = input()
temp = T.replace('+', ' ')
temp = temp.replace('-', ' ')

num = list(map(int, temp.split(' ')))
op = []
for i in list(T):
    if i == '+':
        op.append('+')
    elif i == '-':
        op.append('-')

# sum = 0
# if op[0]!= '+':
#     for i in range(op.index('+')):
