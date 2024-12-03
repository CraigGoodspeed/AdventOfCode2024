package nz.co.goodspeed.advent_2024.days.day3;

public class Equation {

    String equation;
    int left;
    int right;
    String operation;

    public Equation(String equation) {
        this.equation = equation.trim();
        String operation = equation.substring(0, equation.indexOf("("));
        left = Integer.parseInt(equation.substring(operation.length()+1, equation.indexOf(",")));
        right = Integer.parseInt(equation.substring(equation.indexOf(",")+1, equation.indexOf(")")));
        this.operation = operation;
    }

    public long doMath() {
        return (long) left * right;
    }

    @Override
    public String toString() {
        return String.format("%s(%s,%s)",operation, left, right);
    }
}
