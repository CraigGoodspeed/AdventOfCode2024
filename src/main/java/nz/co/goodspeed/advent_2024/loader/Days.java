package nz.co.goodspeed.advent_2024.loader;

public enum Days {
    Tester("Tester.txt"),
    Day2("Day2.txt"),
    Day3("Day3.txt"),
    Day4("Day4.txt"),
    Day5("Day5.txt"),
    Day6("Day6.txt"),
    Day7("Day7.txt"),
    Day1("Day1.txt");
    final String path;
    Days(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}

