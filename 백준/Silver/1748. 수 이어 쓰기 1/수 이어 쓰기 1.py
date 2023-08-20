import sys
input = sys.stdin.readline

N = int(input())
answer = 0

for i in range(1, 100, 1):
    if N >= (10 ** i):
        answer += 9 * (10 ** (i-1)) * i
    else:
        remainder = N % (10 ** i)
        count = remainder - (10 ** (i-1)) + 1
        answer += count * i
        print(answer)
        break