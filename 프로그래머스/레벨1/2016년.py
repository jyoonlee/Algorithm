def solution(a, b):
    day = ['FRI', 'SAT', 'SUN', 'MON', 'TUE', 'WED', 'THU']
    month = [0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]

    if a == 1:
        today = b
    else:
        today = sum(month[:a - 1]) + b

    today %= 7

    return day[today + 1]

