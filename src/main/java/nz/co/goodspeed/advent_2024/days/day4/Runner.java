package nz.co.goodspeed.advent_2024.days.day4;

import java.util.List;

public class Runner {


    public static void main(String[] args) {
        Day4Loader loader = new Day4Loader();
        List<Model> model = loader.LoadData();

        char[][] puzzle = (new Puzzle(model.stream().map(Model::input).toList())).getPuzzle();
        int count = countXmasPart2(puzzle);
        System.out.println(count);
    }

    private static int countXmas(char[][] puzzle) {
        int toReturn = 0;
        int maxLine = puzzle.length;
        int maxColumn = puzzle[0].length;
        Movement[] moves = new Movement[]{
                // | up to down
                new Movement(1, 0, maxLine, maxColumn),
                //down to up
                new Movement(-1, 0, maxLine, maxColumn),
                // -> left to right
                new Movement(0, 1, maxLine, maxColumn),
                // <- right to left
                new Movement(0, -1, maxLine, maxColumn),
                // \ up down right
                new Movement(1, 1, maxLine, maxColumn),
                // / up down left
                new Movement(1, -1, maxLine, maxColumn),
                // \ bottom up left
                new Movement(-1, -1, maxLine, maxColumn),
                // / bottom up right
                new Movement(-1, 1, maxLine, maxColumn),
        };
        char[] MAS = "MAS".toCharArray();
        for(int line = 0; line < maxLine; line++) {
            for(int column = 0; column < maxColumn; column++) {
                if(puzzle[line][column] == 'X') {
                    int counter = 0;
                    int currentLine = line;
                    int currentColumn = column;
                    for(Movement move : moves) {
                        boolean loopBreak = false;
                        for(int i = 0; i < MAS.length && !loopBreak; i++) {
                            int[] next = move.next(currentLine, currentColumn);
                            if(next != null && puzzle[next[0]][next[1]] == MAS[i]) {
                                counter++;
                                currentLine = next[0];
                                currentColumn = next[1];
                            } else{
                                loopBreak = true;
                                currentLine = line;
                                currentColumn = column;
                            }
                        }
                        if(counter == 3) {
                            toReturn++;
                        }
                        currentLine = line;
                        currentColumn = column;
                        counter = 0;
                    }
                }
            }
        }
        return toReturn;
    }

    private static int countXmasPart2(char[][] puzzle) {
        int toReturn = 0;
        int maxLine = puzzle.length;
        int maxColumn = puzzle[0].length;
        Movement[] upLeftDownRight = new Movement[]{
                // up left
                new Movement(-1, -1, maxLine, maxColumn),
                // down right
                new Movement(1, 1, maxLine, maxColumn)
        };

        Movement[] upRightDownLeft = new Movement[]{
                // up right
                new Movement(-1, 1, maxLine, maxColumn),
                // down left
                new Movement(1, -1, maxLine, maxColumn),
        };

        for(int line = 0; line < maxLine; line++) {
            for(int column = 0; column < maxColumn; column++) {
                if(puzzle[line][column] == 'A') {
                    if(isMatch(
                            upLeftDownRight,
                            puzzle,line,
                            column
                    ) &&
                    isMatch(
                            upRightDownLeft,
                            puzzle,line,
                            column
                    )) toReturn++;

                }
            }
        }
        return toReturn;
    }

    public static boolean isMatch(Movement[] moves, char[][] puzzle, int line, int column) {
        String val = "";
        for(Movement move : moves) {
            int[] next = move.next(line, column);
            if(next == null) {
                return false;
            }
            val += puzzle[next[0]][next[1]];
        }
        return val.equals("MS") || val.equals("SM");
    }

    public static char[] isTrigger(char val) {
        if(val == 'A') {
            return "AS".toCharArray();
        }
        if(val == 'S') {
            return "AM".toCharArray();
        }
        return null;
    }

    public static class Movement {
        public int line;
        public int column;
        public int maxLine;
        public int maxColumn;

        public Movement(int line, int column, int maxLine, int maxColumn) {
            this.line = line;
            this.column = column;
            this.maxLine = maxLine;
            this.maxColumn = maxColumn;
        }

        public int[] next(int currentLine,int currentColumn) {
            int newLine = currentLine + this.line;
            int newColumn = currentColumn + this.column;
            if(newLine < 0 || newColumn < 0 || newLine >= maxLine || newColumn >= maxColumn) return null;
            return new int[]{newLine,newColumn};
        }
    }
}
