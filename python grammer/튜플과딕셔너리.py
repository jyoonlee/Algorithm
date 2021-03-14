# 튜플은 한번 선언하면 변경이 더이상 불가능하다
# 다익스트라와 같이 그래프 문제에서 우선순위 큐를 만들 때 활용
# 한번 선언하고 변경하면 안될 때 주로 사용한다

a = (1, 2, 3, 4)
print(a)
# a[2] = 7과 같이 변경은 불가능


# 딕셔너리는 키와 value 형식으로 이루어져있음
# 학생 1000만명 중 1만명이 선택되었다고 했을 때, 선택 여부를 알아보는 경우 효율적으로 저장할 수 있음
# 인덱싱을 지원하지 않기 때문에 key 값으로 접근을 해줘야 함

data = dict()
data['사과'] = 'apple'
data['바나나'] = 'banana'
data['코코넛'] = 'coconut'

print(data)

if '사과' in data:
    print("'사과'는 딕셔너리에 존재합니다")

key_list = data.keys()
print(key_list)
value_list = data.values()
print(value_list)

for key in key_list:
    print(data[key])

# set은 딕셔너리와 마찬가지로 인덱싱을 지원하지 않고, 중복을 허용하지 않는다
# 초기화 방식은 data = set()
# 교집합과 차집합, 합집합을 지원하고 있음

data = {1, 2, 2, 3, 4, 4, 5, 5, 6, 7, 8, 8, 8, 9}
print(data)
print(list(data))  # 이런식으로 중복 체크해서 리스트로 만들어주면 깔끔

a = set([1, 3, 5, 7, 9])
b = set([2, 4, 6, 8, 10])

print(a | b)  # 합집합   !print(a + b)이랑 헷갈리지 말자!
print(a & b)  # 교집합
print(a - b)  # 차집합
print("\n")

a.add(4)
b.update(data)
a.remove(4)
print(a)
print(b)
