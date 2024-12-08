package nz.co.goodspeed.advent_2024.days.day6;

import java.util.List;

public class Runner {
    public static void main(String[] args) {

        Day6Loader loader = new Day6Loader();

        List<Model> data = loader.LoadData();

        char[][] grid = new char[data.size()][];
        char guardChar = '^';
        int row = -1;
        int column = -1;
        for(int i = 0; i < data.size(); i++) {
            String line =data.get(i).input();
            int hasGuard = line.indexOf(guardChar);
            if(hasGuard != -1) {
                row = i;
                column = hasGuard;
                guardChar = line.charAt(hasGuard);
            }

            grid[i] = data.get(i).input().toCharArray();
        }

        Guard guard = new Guard(row, column, Guard.convertCharToDirection(guardChar));

        while(!guard.isExiting) {
            guard.move(grid);
        }

        System.out.println("part 1 "+guard.visited);
        System.out.println("part 2 "+guard.potentialLoops);

    }
}
