#변수 선언
n=5
grid=[
    [0,0,0,0,0],
    [0,1,0,0,0],
    [0,0,1,0,1],
    [0,0,0,0,0],
    [0,0,0,1,0],
]

def get_num_of_gold(row,col_s,col_e):
    num_of_gold=0

    for col in range(col_s,col_e+1):
        num_of_gold += grid[row][col]

    return num_of_gold

max_gold=0

for row in range(n):
    for col in range(n):
        if col + 2 >= n:
            continue

        num_of_gold=get_num_of_gold(row,col,col+2)

        max_gold=max(max_gold,num_of_gold)

print(max_gold)

