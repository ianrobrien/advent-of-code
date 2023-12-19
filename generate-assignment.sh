#!/bin/bash

# Display usage instructions if no arguments are provided
if [ "$#" -eq 0 ]; then
    echo "Usage: ./script.sh -y <year> -d <day> -n <assignment_name>"
    echo "Options:"
    echo "  -y, --year <year>           Specify the year (2 or 4 digits)"
    echo "  -d, --day <day>             Specify the day (01-31)"
    echo "  -n, --name <assignment_name> Specify the assignment name"
    exit 1
fi

# Initialize variables
year=""
day=""
assignment_name=""

# Function to format year
format_year() {
    local input_year=$1
    local year_length=${#input_year}

    if [ "$year_length" -eq 2 ]; then
        year=$((20$input_year))
    elif [ "$year_length" -eq 4 ]; then
        year=$input_year
        if [[ ! "$year" =~ ^20 ]]; then
            echo "Invalid year format. Year should start with '20' for 4-digit inputs."
            exit 1
        fi
    else
        echo "Invalid year format. Please provide either 2 or 4 digits for the year."
        exit 1
    fi
}

# Function to format day
format_day() {
    local input_day=$1

    if [[ "$input_day" =~ ^0?[1-9]$|^1[0-9]$|^2[0-9]$|^3[0-1]$ ]]; then
        if [ ${#input_day} -eq 1 ]; then
            day="0$input_day"
        else
            day=$input_day
        fi
    else
        echo "Invalid day format. Please provide a day between 01 and 31."
        exit 1
    fi
}

# Parse arguments
while [[ $# -gt 0 ]]; do
    key="$1"

    case $key in
        -y|--year)
            format_year "$2"
            shift
            shift
            ;;
        -d|--day)
            format_day "$2"
            shift
            shift
            ;;
        -n|--name)
            assignment_name="$2"
            shift
            shift
            ;;
        *)
            echo "Unknown option: $1"
            exit 1
            ;;
    esac
done

# Validate inputs
if [ -z "$year" ] || [ -z "$day" ] || [ -z "$assignment_name" ]; then
    echo "Please provide year, day, and assignment name arguments."
    exit 1
fi

# Create directories
main_dir="src/main/java/no/obrien/year${year}/day${day}"
test_dir="src/test/java/no/obrien/year${year}/day${day}"
resource_dir="src/test/resources/year${year}/day${day}"

mkdir -p "$main_dir"
mkdir -p "$test_dir"
mkdir -p "$resource_dir"

# Create Java files with provided content
echo "package no.obrien.year${year}.day${day};

import java.util.List;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ${assignment_name} {

  public int partOne(List<String> lines) {
    return 0;
  }

  public int partTwo(List<String> lines) {
    return 0;
  }
}" > "${main_dir}/${assignment_name}.java"

echo "package no.obrien.year${year}.day${day};

import static org.junit.jupiter.api.Assertions.assertEquals;

import no.obrien.utils.FileUtils;
import org.junit.jupiter.api.Test;

class ${assignment_name}Test {

  private static final String INPUT_FILE_PATH = \"year${year}/${assignment_name}.txt\";

  @Test
  void testPartOne() {
    assertEquals(
        0,
        ${assignment_name}.partOne(FileUtils.parseInputFile(INPUT_FILE_PATH)));
  }

  @Test
  void testPartTwo() {
    assertEquals(
        0,
        ${assignment_name}.partTwo(FileUtils.parseInputFile(INPUT_FILE_PATH)));
  }

  @Test
  void testPartOneSample() {
    var input = \"\"\"
\"\"\";
    assertEquals(0, ${assignment_name}.partOne(input.lines().toList()));
  }

  @Test
  void testPartTwoSample() {
    var input = \"\"\"
\"\"\";
    assertEquals(0, ${assignment_name}.partTwo(input.lines().toList()));
  }
}" > "${test_dir}/Test${assignment_name}.java"

# Create empty resource file
touch "${resource_dir}/${assignment_name}.txt"

echo "Directories and Java files created:"
echo "Main directory: $main_dir/${assignment_name}.java"
echo "Test directory: $test_dir/Test${assignment_name}.java"
echo "Resource directory: $resource_dir/${assignment_name}.txt"
