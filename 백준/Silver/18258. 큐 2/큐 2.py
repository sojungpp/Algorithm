from collections import deque
import sys
input = sys.stdin.readline
q = deque()

N = int(input()) # 명령어의 수
for i in range(N):
    cmd = input().split()

    if cmd[0] == 'push':
        num = cmd[1]
        q.append(num)

    elif cmd[0] == 'pop':
        if len(q) == 0:
            print(-1)
        else:
            print(q.popleft())

    elif cmd[0] == 'size':
        print(len(q))

    elif cmd[0] == 'empty':
        if len(q) == 0:
            print(1)
        else:
            print(0)

    elif cmd[0] == 'front':
        if len(q) == 0:
            print(-1)
        else:
            print(q[0])

    elif cmd[0] == 'back':
        if len(q) == 0:
            print(-1)
        else:
            print(q[len(q)-1])