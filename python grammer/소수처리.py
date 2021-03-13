# 지수

a = 1e9
print(a)

a = 724e3
print(a)

a = 724e-3
print(a)

a = .3 + .6
print(a)  # 0.9가 나와야하지만 0.899999가 나옴

if a == 0.9:  # False
    print(True)
else:
    print(False)

a = 0.3
b = 0.6
print(a + b == 0.9)  # False

# round
# 위처럼 소수 연산이 잘 안이루어지면 round 함수를 통해 해결

a = 0.3 + 0.6
print(round(a))  # 첫째 자리에서 반올림
print(round(a, 2))  # 둘째 자리에서 반올림

print(3/2)  # 우리가 아는 나눗셈  1.5
print(3//2)   # 몫만 나누기  1

print(3**2)  # 제곱  9


