# 숫자 n이 주어지면 n + 각 자리수 더해서 수를 만든다
# 이때 파생된 수가 아닌 것들을 출력하는 문제 

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
