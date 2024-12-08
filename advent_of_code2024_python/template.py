

def parse_line(line):
    leftAndRight = line.split(': ')

    left = leftAndRight[0]

    right = leftAndRight[1].split(' ')

    obj = ()
    obj.left = left
    obj.right = right
    return obj



def read_file(path):
    to_return = []
    with open(path) as input:
        for line in input:
            to_return.append(line.strip("\n"))

    return to_return

if __name__ == '__main__':
    input = read_file('./input/day7.txt')
    parsed_data = []
    for line in input:
        parsed_data.append(parse_line(line))

    print(parsed_data)

