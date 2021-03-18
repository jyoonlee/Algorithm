word = list(input().upper())

uniq_word = list(set(word))

count_arr = []
for i in uniq_word:
    count_arr.append(word.count(i))

if count_arr.count(max(count_arr)) >= 2:
    print("?")
else:
    print(uniq_word[count_arr.index(max(count_arr))])
