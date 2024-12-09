import math

from pyparsing import Empty


class file:
    def __init__(self, id, blocks, space):
        self.id = int(id)
        self.blocks = int(blocks)
        self.space = int(space)
        self.moved = False
        self.blocks_added = 0





def print_str(files):
    to_return = ''
    for fle in files:
        id = str(fle.id)
        blocks = int(fle.blocks)
        to_return = to_return +  (id * blocks) + ('.' * int(fle.space))
    return to_return

def get_file_by_id(id, files):
    for file in files:
        if file.id == id:
            return file
    return ""

def find_first_group_with_empties(data, blocks):
    for file in data:
        if file.space >= blocks:
            return file
    return None

def as_collection(files):
    to_return = []
    for fle in files:
        id = fle.id
        for i in range(int(fle.blocks)):
            to_return.append(id)
        for i in range(int(fle.space)):
            to_return.append('.')
    return to_return

def first_empty_index(col):
    return col.index('.')

def count_empties(col):
    first_empty = first_empty_index(col)
    count = 1
    for i in range(first_empty, len(col),1):
        if(col[i] == '.'):
            count = count + 1
        else:
            return (first_empty, count)


def move_items(col, data):
    for index in range(len(col)-1, 0, -1):
        if col[index] == '.':
            continue
        file = get_file_by_id(col[index], data)
        file_dest = find_first_group_with_empties(data, file.blocks)
        if file_dest is None or file.moved:
            continue

        start_index = col.index(file_dest.id) + int(file_dest.blocks) + file_dest.blocks_added
        items_moved = 0
        for i in range(start_index, (start_index + int(file.blocks)), 1):
            tmp = col[i]
            col[i] = col[index - items_moved]
            col[index - items_moved] = tmp
            file_dest.space = file_dest.space - 1
            file.blocks = file.blocks + 1
            items_moved = items_moved + 1
            file_dest.blocks_added = file_dest.blocks_added + 1
        file.moved = True
    return col

def get_checksum(calc_ready):
    return_me = 0
    for i in range(0, len(calc_ready), 1):
        if calc_ready[i] == '.':
            continue

        return_me = return_me + (i * calc_ready[i])
    return return_me

def read_file(path):
    with open(path) as input:
        for line in input:
            return line.strip('\n')



if __name__ == '__main__':
    data = []

    input = read_file('./input/day9.txt')

    counter = 0

    max = math.ceil(len(input) / 2)
    index = 0

    length = len(input)

    while counter < max:
        data.append(
            file(
                counter,
                '0' if index >= length else input[index],
                '-1' if index+1 >= length else input[index+1]
            )
        )
        counter = counter + 1
        index = index + 2


    as_str = print_str(data)
    col = as_collection(data)

    filter_ready = move_items(col, data)

    #calculate_ready = filter(lambda item: item != '.', filter_ready)
    #calculate_ready = list(calculate_ready)


    print(get_checksum(filter_ready))



