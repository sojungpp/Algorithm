import sys
input = sys.stdin.readline

N = int(input())
result = 0
num = 0

for _ in range(N):
    num += 1
    result += N // num * num

print(result)