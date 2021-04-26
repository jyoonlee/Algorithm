
phone_book = ['12' ,'456' ,'789', '1012']
phone_book.sort()

value = True
for p1, p2 in zip(phone_book, phone_book[1:]):
    if p2.startswith(p1):
        value = False
        break

print(value)
