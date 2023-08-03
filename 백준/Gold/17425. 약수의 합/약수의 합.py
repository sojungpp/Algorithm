import sys
input = sys.stdin.readline


MAX = 1000000
dp = [0] * (MAX + 1)
g = [0] * (MAX + 1)

for i in range(1, MAX+1):
    j = 1
    while i * j <= MAX:
        dp[i * j] += i
        j += 1
    g[i] = g[i-1] + dp[i]

T = int(input())

for _ in range(T):
    N = int(input())
    print(g[N], end="\n")