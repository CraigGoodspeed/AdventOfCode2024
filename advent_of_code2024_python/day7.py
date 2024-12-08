import itertools
import math


def parse_line(line):
    leftAndRight = line.split(': ')

    left = leftAndRight[0]

    right_str = leftAndRight[1].split(' ')
    right = []
    for item in right_str:
        right.append(int(item))

    obj = {
        'left': left,
        'right': right,
        'results': [],
        'is_contained': False
    }
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


    summed = 0

    for line in parsed_data:
        operations = []
        for i in line['right']:
            operations.append(['*','+','||'])
        operations = list(itertools.product(*operations))
        result =line['results']
        for operation in operations:
            counter =  1
            op_count = 0
            result.append(line['right'][0])
            while counter < len(line['right']):
                if operation[op_count] == '*':
                    result[len(result) - 1] = result[len(result) - 1] * line['right'][counter]
                elif operation[op_count] == '+':
                    result[len(result) - 1] = result[len(result) - 1] + line['right'][counter]
                elif operation[op_count] == '||':
                    result[len(result) - 1] = int(str(result[len(result) - 1]) + str(line['right'][counter]))
                counter = counter + 1
                op_count = op_count + 1
        if int(line['left']) in result:
            summed = summed + int(line['left'])


    print(summed)

