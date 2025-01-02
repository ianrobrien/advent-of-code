import os

def read_file_lines(filepath):
    """
    Reads the file at the given filepath and returns a list of lines.

    :param filepath: Path to the file
    :return: List of lines in the file
    """
    try:
        with open(filepath, 'r') as file:
            lines = file.readlines()
            return lines
    except FileNotFoundError:
        print(f"File not found: {filepath}")
        return None