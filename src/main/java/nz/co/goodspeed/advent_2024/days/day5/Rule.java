package nz.co.goodspeed.advent_2024.days.day5;

public class Rule {
    int first;
    int second;

    public Rule(
            String data
    ) {
        String[] parts = data.split("\\|");
        this(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
    }

    public Rule(int first, int second) {
        this.first = first;
        this.second = second;
    }

    public int getFirst() {
        return first;
    }

    public void setFirst(int first) {
        this.first = first;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }
}
