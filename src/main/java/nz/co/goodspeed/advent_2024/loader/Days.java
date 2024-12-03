package nz.co.goodspeed.advent_2024.loader;

public enum Days {
    Tester("Tester.txt"),
    Day2("Day2.txt"),
    Day3("Day3.txt"),
    Day4("Day4.txt"),
    Day1("Day1.txt");
    final String path;
    Days(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}

