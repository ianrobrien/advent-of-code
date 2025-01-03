import re

from python.year2024.common.utils import read_file_lines

def part_one(filepath):
  """
  Reads the file at the given filepath and counts the number of lines.

  :param filepath: Path to the file
  :return: Number of lines in the file
  """
  lines = read_file_lines(filepath)
  if lines is not None:
    result = 0
    pattern = r"mul\((\d+),(\d+)\)"
    for line in lines:
      matches = re.findall(pattern, line)
      for match in matches:
        x, y = int(match[0]), int(match[1])
        result += x * y
    return result
  return None

def part_two(filepath):
  """
  Reads the file at the given filepath and counts the number of lines.

  :param filepath: Path to the file
  :return: Number of lines in the file
  """
  lines = read_file_lines(filepath)
  if lines is not None:
    result = 0
    pattern = r".*?(mul\((\d+),(\d+)\)|don't\(\)|do\(\))"
    enabled = True
    for line in lines:
      matches = re.finditer(pattern, line)
      for match in matches:
        if match.group(0):
          if "don't()" in match.group(0):
            enabled = False
          elif "do()" in match.group(0):
            enabled = True
          elif enabled:
            result += int(match[2]) * int(match[3])
    return result
  return None
