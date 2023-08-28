import sys
input = sys.stdin.readline

N, M = map(int, input().split())
answer = []
visited = [0] * (N + 1)


def dfs(n, arr):
    if n == M: # M개 수열을 다 저장하면 종료
        answer.append(arr)
        return

    for j in range(1, N + 1):
        if visited[j] == 0: # 아직 선택하지 않은 경우
            visited[j] = 1
            dfs(n + 1, arr + [j])
            visited[j] = 0 # 호출 후, 선택여부 돌려놓기


dfs(0, [])
for arr in answer:
    print(*arr)