num_value = int(input())

num = num_value
count = 0

while True:
    count += 1

    a = num // 10
    b = num % 10

    sum = a+b
    c = sum % 10

    num = b*10+c

    # 간단하게 나타내면 a = (temp % 10) * 10 + (temp // 10 + temp % 10) % 10 

    if num == num_value:
        break

print(count)



