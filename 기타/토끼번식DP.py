# 레오 피보는 어느날 "토끼가 한 쌍 있다면 몇 달이 지난 후에 몇 쌍으로 늘어날까?"라는 생각을 했답니다.
# 문제를 단순화하기 위해 몇 가지 가정을 했어요.
# 모든 쌍은 한 배에 암수 한 쌍을 낳습니다.
# 그리고 토끼는 불로장생합니다.
# 토기 암컷은 태어난 지 한 달이면 새끼를 낳을 수 있으며 그 후로 계속해서 한 달에 암수 한 쌍을 낳습니다.
# 20달 뒤에 몇 쌍을 낳는지 판단하는 프로그램을 작성하세요.
# (한 번 풀었던 문제의 답을 다시 이용하는 형태로 작성하세요.)


# 일반적인 피보나치 수열 변형한건데, 이건 시간이 너무 오래걸림 fibo2가 DP 적용 함수 
def fibo(n):
    if n <= 0:
        return 0
    if n == 1 or n == 2:
        return 1
    return fibo(n - 1) + fibo(n - 2)


heues = [0, 1, 1]


def fibo2(n):
    if n <= 0:
        return 0
    if heues[n] == 0:
        heues[n] = fibo2(n - 1) + fibo2(n - 2)
    return heues[n]


for i in range(3, 101):
    heues.append(0)  # 아직 계산 안된 정보

for i in range(0, 101):
    print(i, end=' ')
    print(fibo2(i))
