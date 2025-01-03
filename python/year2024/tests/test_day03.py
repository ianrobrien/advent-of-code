import unittest
import os

from python.year2024.days.day03 import part_one, part_two

class TestPartFunctions(unittest.TestCase):
    def test_part_one(self):
        resources_dir = os.path.abspath(os.path.join(os.path.dirname(__file__), '..', 'resources'))
        file_path = os.path.join(resources_dir, 'day03.txt')
        safe_count = part_one(file_path)

        # Assert the safe count value
        expected_safe_count = 196826776
        self.assertEqual(expected_safe_count, safe_count)

    def test_part_two(self):
        resources_dir = os.path.abspath(os.path.join(os.path.dirname(__file__), '..', 'resources'))
        file_path = os.path.join(resources_dir, 'day03.txt')
        safe_count = part_two(file_path)

        # Assert the safe count value
        expected_safe_count = 106780429
        self.assertEqual(expected_safe_count, safe_count)

if __name__ == '__main__':
    unittest.main()