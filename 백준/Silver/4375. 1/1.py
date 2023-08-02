import sys
input = sys.stdin.readline


while 1:
    try:
        n = int(input())
    except:
        break

    result = 1
    dividend = 1;
    while 1:
        temp = dividend % n
        if temp == 0:
            print(result)
            break
        result += 1
        dividend = temp * 10 + 1