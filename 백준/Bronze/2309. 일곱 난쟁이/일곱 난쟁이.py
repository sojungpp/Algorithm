import sys
input = sys.stdin.readline
people = []

for _ in range(9):
    people.append(int(input()))

people.sort()

for i in people:
    for j in people:
        total = sum(people) - i - j
        if total == 100:
            people.remove(i)
            people.remove(j)

print(*people, end="\n")