# 종료문이 없는 조건문 

try:
    while True:
        a, b = map(int, input().split())
        print(a + b)
except:
    print("")
