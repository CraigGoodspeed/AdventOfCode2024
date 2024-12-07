package nz.co.goodspeed.advent_2024.days.day5;

import java.util.ArrayList;
import java.util.List;

public class ConsolidateRulesV2 {
    List<Integer> actualSequence;


    public ConsolidateRulesV2(List<Rule> input) {
        List<Rule> rules = new ArrayList<>(input);
        actualSequence = new ArrayList<>();
        actualSequence.addAll(List.of(rules.get(0).getFirst(), rules.get(0).getSecond()));
        int otherCounter= 0;
        int counter = 0;
        while(!rules.isEmpty()) {
            int index = actualSequence.indexOf(rules.get(counter).getFirst());
            if(index > -1) {
                if(index == actualSequence.size()) {
                    actualSequence.add(rules.get(counter).getSecond());
                } else {
                    int indexOfSecond = actualSequence.indexOf(rules.get(counter).getSecond());
                    if(indexOfSecond > -1) {
                        if(indexOfSecond < index) {
                            actualSequence.remove(indexOfSecond);
                            actualSequence.add(index, rules.get(counter).getSecond());
                        } else {
                            otherCounter++;
                        }

                    }
                    else {
                        actualSequence.add(index+1, rules.get(counter).getSecond());
                    }

                }
                rules.remove(counter);
                counter = 0;
            } else {
                counter++;
            }
        }
        System.out.println(otherCounter);
    }
    public List<Integer> getActualSequence() {
        return actualSequence;
    }
}
