import sys
input = sys.stdin.readline

N = int(input())
result = 0
target = list(map(int, input().split()))

for i in target:
    count = 0
    if i < 2:
        continue
    for j in range(2, i):
        if i % j == 0:
            count += 1
    if count == 0:
        result += 1
print(result)