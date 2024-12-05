package nz.co.goodspeed.advent_2024.days.day5;

import java.util.ArrayList;
import java.util.List;

public class ConsolidateRules {

    int left;

    List<Integer> right;

    public ConsolidateRules(int left, List<Rule> toConsolidate) {
        this.left = left;
        right = new ArrayList<>();
        toConsolidate.stream().filter(i -> i.getFirst() == left).forEach(i -> right.add(i.getSecond()));
    }

    public int getLeft() {
        return left;
    }

    public List<Integer> getRight() {
        return right;
    }
}
