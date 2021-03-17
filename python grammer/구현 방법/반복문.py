# while문은 무한 루프 조심
i = 1
result = 0

while i <= 9:
    result += i
    i += 1

print(i)

# for문은 인덱스를 차례차례 방문함
# in 뒤에 오는 인자로는 리스트, 튜플, 문자열 등이 사용될 수 있음
result = 0

for i in range(1, 10):
    result += i
print(result)


# 중첩된 포문은 플로이드 워셜 + 다이나믹 프로그래밍 등에서 사용된다


# for문 거꾸로
n = int(input())
for i in range(n, 0, -1):
    print(i)

