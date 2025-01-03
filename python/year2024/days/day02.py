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
      if check_is_safe([int(num) for num in line.split()]):
        safe_count += 1

    return safe_count
  return None

def part_two(filepath):
  """
  Reads the file at the given filepath and counts the number of words.

  :param filepath: Path to the file
  :return: Number of words in the file
  """
  """
  Reads the file at the given filepath and counts the number of lines.

  :param filepath: Path to the file
  :return: Number of lines in the file
  """
  lines = read_file_lines(filepath)
  if lines is not None:
    safe_count = 0
    for line in lines:
      if check_is_safe([int(num) for num in line.split()]):
        safe_count += 1
      else:
        if check_can_fix([int(num) for num in line.split()]):
          safe_count += 1

    return safe_count
  return None

def check_is_safe(array):
  sorted_array = sorted(array)
  reversed_array = sorted(array, reverse=True)
  if sorted_array == array or reversed_array == array:
    for i in range(len(array) - 1):
      difference = abs(array[i] - array[i + 1])
      if difference < 1 or difference > 3:
        return False
  else:
    return False
  return True

def check_can_fix(array):
  for i in range(len(array)):
    new_array = array[:i] + array[i + 1:]
    if check_is_safe(new_array):
      return True
  return False