package nz.co.goodspeed.advent_2024.days.day5;

import java.util.ArrayList;
import java.util.List;

public class ConsolidateRulesV2 {
    List<Integer> actualSequence;
    public ConsolidateRulesV2(List<Rule> rules) {
        actualSequence = new ArrayList<>();
        actualSequence.addAll(List.of(rules.get(0).getFirst(), rules.get(0).getSecond()));
        int counter = 0;
        while(!rules.isEmpty()) {
            int index = actualSequence.indexOf(rules.get(counter).getFirst());
            if(index > -1) {
                if(index == actualSequence.size()) {
                    actualSequence.add(rules.get(counter).getSecond());
                } else {
                    actualSequence.add(index+1, rules.get(counter).getSecond());
                }
                rules.remove(counter);
                counter = 0;
            } else {
                counter++;
            }
        }
    }
    public List<Integer> getActualSequence() {
        return actualSequence;
    }
}
