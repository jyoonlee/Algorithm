def solution(s):
    answer = ''
    li = s.split(' ')
    for i in li:
        temp = ''
        for j in range(len(i)):
            if j % 2 == 0:
                temp += i[j].upper()
            else:
                temp += i[j].lower()

        temp += ' '
        answer += temp

    return answer[:-1]