x = []
y = []

for _ in range(3):
    a, b = map(int, input().split())
    x.append(a)
    y.append(b)

_x = 0
_y = 0
for i in range(3):
    if x.count(x[i]) == 1:
        _x = x[i]
    if y.count(y[i]) == 1:
        _y = y[i]

print("{} {}".format(_x, _y))
