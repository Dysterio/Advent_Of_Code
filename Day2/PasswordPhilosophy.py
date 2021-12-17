data = []
with open("./input.txt", "r") as file:
    for line in file:
        elems = line.split(" ")
        nums = elems[0].split("-")
        data.append({
            "n1": int(nums[0]),
            "n2": int(nums[1]),
            "char": elems[1][0],
            "pw": " ".join(elems[2:])
        })

valid_pw = 0
for d in data:
    occ = d["pw"].count(d["char"])
    if d["n1"] <= occ <= d["n2"]:
        valid_pw += 1
print(f"Part 1: {valid_pw}")

valid_pw = 0
for d in data:
    if (d["pw"][d["n1"] - 1] == d["char"]) ^ (d["pw"][d["n2"] - 1] == d["char"]):
        valid_pw += 1
print(f"Part 2: {valid_pw}")
