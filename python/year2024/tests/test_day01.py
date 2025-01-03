import unittest
import os

from python.year2024.days.day01 import part_one, part_two

class TestPartFunctions(unittest.TestCase):
    def test_part_one(self):
        resources_dir = os.path.abspath(os.path.join(os.path.dirname(__file__), '..', 'resources'))
        file_path = os.path.join(resources_dir, 'day01.txt')
        first_column, second_column, distance = part_one(file_path)

        # Assert the distance value
        expected_distance = 1258579
        self.assertEqual(expected_distance, distance)

    def test_part_two(self):
        resources_dir = os.path.abspath(os.path.join(os.path.dirname(__file__), '..', 'resources'))
        file_path = os.path.join(resources_dir, 'day01.txt')
        first_column, second_column, similarity = part_two(file_path)

        # Assert the distance value
        expected_similarity = 23981443
        self.assertEqual(expected_similarity, similarity)

if __name__ == '__main__':
    unittest.main()