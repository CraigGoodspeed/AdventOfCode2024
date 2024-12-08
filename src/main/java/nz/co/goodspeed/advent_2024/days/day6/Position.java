package nz.co.goodspeed.advent_2024.days.day6;

import java.util.Objects;

public class Position {
    int row;
    int col;
    char item;
    Guard.Direction direction;

    public Position(int row, int col, char item, Guard.Direction direction) {
        this.row = row;
        this.col = col;
        this.item = item;
        this.direction = direction;
    }

    public boolean isObstacle() {
        return isObstacle(item);
    }

    public static boolean isObstacle(char val) {
        return val == '#';
    }

    public char getItem() {
        return item;
    }

    public void setItem(char item) {
        this.item = item;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return row == position.row && col == position.col;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col);
    }

    public boolean potentialLoop(Position other) {
        return Guard.rotate90Degrees(direction) == other.direction && other.equals(this);
    }
}
