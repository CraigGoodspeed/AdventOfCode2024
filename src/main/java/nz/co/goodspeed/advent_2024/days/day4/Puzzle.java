package nz.co.goodspeed.advent_2024.days.day4;

import java.util.List;

public class Puzzle {
    char[][] puzzle;

    public Puzzle(List<String> lines) {
        puzzle = new char[lines.get(0).length()][lines.size()];
        for(int i = 0; i < lines.size(); i++) {
            puzzle[i] = lines.get(i).toCharArray();
        }
    }

    public char[][] getPuzzle() {
        return puzzle;
    }
}
