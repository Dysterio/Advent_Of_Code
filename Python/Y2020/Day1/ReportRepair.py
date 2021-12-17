data = []
with open("input.txt", "r") as file:
    for line in file:
        data.append(int(line))

part1, part2 = None, None
for i in range(len(data)):
    for j in range(i, len(data)):
        if data[i] + data[j] == 2020:
            part1 = data[i] * data[j]
        for k in range(j, len(data)):
            if data[i] + data[j] + data[k] == 2020:
                part2 = data[i] * data[j] * data[k]

print(f"Part 1: {part1}")
print(f"Part 2: {part2}")
