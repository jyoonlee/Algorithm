def myfunction(n):
    if n == 0:
        return 0
    return n%10 + myfunction(n//10)


number = []

for i in range(1,10001):
    number.append(i + myfunction(i))
    if i in number:
        continue
    print(i)
