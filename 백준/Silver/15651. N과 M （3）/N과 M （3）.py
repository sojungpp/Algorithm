import sys
input = sys.stdin.readline

N, M = map(int, input().split())
answer = []


def dfs(n, arr, num):
    if n == M: # M개 수열을 다 저장하면 종료
        answer.append(arr)
        return

    for j in range(1, N + 1):
            dfs(n + 1, arr + [j], j)


dfs(0, [], 0)
for arr in answer:
    print(*arr)