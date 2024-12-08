package nz.co.goodspeed.advent_2024.days.day6;

import nz.co.goodspeed.advent_2024.days.day4.Runner;

import java.util.HashSet;
import java.util.Set;

public class Guard {

    public enum Direction {
        UP, DOWN, LEFT, RIGHT
    }
    Direction direction;
    int row, column;
    Set<Position> visited;
    boolean isExiting = false;
    Set<Position> potentialLoops;

    public Guard(int row, int column, Direction direction) {
        this.row = row;
        this.column = column;
        this.direction = direction;
        visited = new HashSet<>();
        potentialLoops = new HashSet<>();
    }

    public void rotate90Degrees() {
        direction = Guard.rotate90Degrees(direction);
    }

    public static Direction convertCharToDirection(char c) {
        return switch (c) {
            case 'v' -> Direction.DOWN;
            case '>' -> Direction.RIGHT;
            case '<' -> Direction.LEFT;
            default -> Direction.UP;
        };
    }

    public void move(char[][] grid) {
        Position thisPosition = new Position(row,column, grid[row][column], direction);
        visited.add(thisPosition);
        for(Position loop : visited) {
            if(loop.potentialLoop(thisPosition)) {
                NewMovement newMovement = getMovement(
                        loop.direction,
                        loop.getRow(),
                        loop.getCol()
                );
                Position addMe = new Position(newMovement.getRow(), newMovement.getColumn(), loop.item, loop.direction);
                potentialLoops.add(addMe);
            }
        }

        NewMovement movement = getMovement(direction, row, column);
        int newRow = movement.getRow();
        int newColumn = movement.getColumn();


        isExiting = (
                newRow < 0 || newRow >= grid.length
                        || (newColumn < 0 || newColumn >= grid[0].length));
        if(isExiting)
            return;

        if(Position.isObstacle(grid[newRow][newColumn])) {
            rotate90Degrees();
        } else {
            row = newRow;
            column = newColumn;
        }


    }

    public NewMovement getMovement(Direction movementDirection, int currentRow, int currentColumn) {
        int newRow = currentRow;
        int newColumn = currentColumn;
        switch (movementDirection) {
            case UP: {
                newRow = row - 1;
                break;
            }
            case DOWN: {
                newRow = row + 1;
                break;
            }
            case LEFT: {
                newColumn = column - 1;
                break;
            }
            case RIGHT: {
                newColumn = column + 1;
                break;
            }
        }
        return new NewMovement(newRow, newColumn);
    }

    public static Direction rotate90Degrees(Direction sourceDirection) {
        return switch (sourceDirection) {
            case UP -> Direction.RIGHT;
            case DOWN -> Direction.LEFT;
            case LEFT -> Direction.UP;
            case RIGHT -> Direction.DOWN;
        };
    }

    public Set<Position> getPotentialLoops() {
        return potentialLoops;
    }
}
