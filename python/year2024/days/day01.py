from python.year2024.common.utils import read_file_lines

def part_one(filepath):
  """
  Reads the file at the given filepath and counts the number of lines.

  :param filepath: Path to the file
  :return: Number of lines in the file
  """
  lines = read_file_lines(filepath)
  if lines is not None:
    first_column = []
    second_column = []
    for line in lines:
      values = line.strip().split()
      if len(values) == 2:
        first_column.append(int(values[0]))
        second_column.append(int(values[1]))
    first_column.sort()
    second_column.sort()

    distance = 0
    for i in range(min(len(first_column), len(second_column))):
      distance += abs(first_column[i] - second_column[i])

    return first_column, second_column, distance
  return None, None, None

def part_two(filepath):
  """
  Reads the file at the given filepath and counts the number of words.

  :param filepath: Path to the file
  :return: Number of words in the file
  """
  lines = read_file_lines(filepath)
  if lines is not None:
    size = 100000
    first_column = [0] * size
    second_column = [0] * size

    lines = read_file_lines(filepath)
    if lines is not None:
        for i, line in enumerate(lines):
            if i >= size:
                break
            values = line.strip().split()
            if len(values) == 2:
                first_column[int(values[0])] = first_column[int(values[0])]+1
                second_column[int(values[1])] = second_column[int(values[1])]+int(values[1])

    similarity = 0
    for i in range(size):
      similarity += first_column[i] * second_column[i]

    return first_column, second_column, similarity
  return None, None, None