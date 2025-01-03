import unittest
import os

from python.year2024.days.day02 import part_one, part_two

class TestPartFunctions(unittest.TestCase):
    def test_part_one(self):
        resources_dir = os.path.abspath(os.path.join(os.path.dirname(__file__), '..', 'resources'))
        file_path = os.path.join(resources_dir, 'day02.txt')
        safe_count = part_one(file_path)

        # Assert the safe count value
        expected_safe_count = 379
        self.assertEqual(safe_count, expected_safe_count)

    def test_part_two(self):
        resources_dir = os.path.abspath(os.path.join(os.path.dirname(__file__), '..', 'resources'))
        file_path = os.path.join(resources_dir, 'day02.txt')
        first_column, second_column, similarity = part_two(file_path)

        # Assert the distance value
        expected_similarity = 23981443
        self.assertEqual(similarity, expected_similarity)

if __name__ == '__main__':
    unittest.main()