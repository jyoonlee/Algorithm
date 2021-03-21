# 단어가 주어지면 알파벳이 있는 지 찾기

word = list(input())
count = [-1 for _ in range(26)]

for i in word:
    count[ord(i)-97] = word.index(i)

for j in count:
    print(j, end=" ")