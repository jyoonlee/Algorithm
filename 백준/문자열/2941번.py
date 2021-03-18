# 크로아티아 언어

answer = ['c=', 'c-', 'dz=', 'd-', 'lj', 'nj', 's=', 'z=']
word = input()

count = 0
for i in answer:
    if i in word:
        count += word.count(i)
        word = word.replace(i, ' ')

word = word.replace(' ', '')
print(count + len(word))
