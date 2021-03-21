# 입력한 10가지 수를 42로 나누었을 때 서로 다른 나머지를 가진 건 몇개인가?

result = []
for i in range(10):
    result.append(int(input()) % 42)

print(len(set(result)))
