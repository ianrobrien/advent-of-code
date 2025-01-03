from python.year2024.common.utils import read_file_lines

def part_one(filepath):
  """
  Reads the file at the given filepath and counts the number of lines.

  :param filepath: Path to the file
  :return: Number of lines in the file
  """
  lines = read_file_lines(filepath)
  if lines is not None:
    safe_count = 0
    for line in lines:
      array = [int(num) for num in line.split()]
      sorted_array = sorted(array)
      reversed_array = sorted(array, reverse=True)

      if sorted_array == array or reversed_array == array:
        safe = True
        for i in range(len(array) - 1):
          difference = abs(array[i] - array[i + 1])
          if difference < 1 or difference > 3:
            safe = False
            break
        if safe:
            safe_count += 1


    return safe_count
  return None

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