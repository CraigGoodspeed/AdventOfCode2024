package nz.co.goodspeed.advent_2024.days.day5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PageUpdate {
    List<Integer> pageData;

    public PageUpdate(String data) {
        this(Arrays.stream(data.split(",")).map(Integer::parseInt).collect(Collectors.toList()));
    }

    public PageUpdate(List<Integer> pageData) {
        this.pageData = pageData;
    }

    public List<Integer> getPageData() {
        return pageData;
    }

    public boolean isOrderedCorrectly(List<Integer> tmp, List<Rule> rules) {
        boolean result = true;
        for (Rule rule : rules) {
            int first = tmp.indexOf(rule.getFirst());
            int second = tmp.indexOf(rule.getSecond());
            result = result && (first < second || first == -1 || second == -1);
        }
        return result;
    }

    public boolean isOrderedCorrectly(List<Rule> rules) {
        return isOrderedCorrectly(pageData, rules);
    }

    public List<Rule> getViolatingRules(List<Rule> rules) {
        List<Rule> result = new ArrayList<>();
        for (Rule rule : rules) {
            int first = pageData.indexOf(rule.getFirst());
            int second = pageData.indexOf(rule.getSecond());
            if(first > second && second != -1) {
                result.add(rule);
            }
        }
        return result;
    }

    public List<Integer> orderCorrectly(List<Integer> data, List<ConsolidateRules> rules) {
        int[] newData = new int[data.size()];
        Arrays.fill(newData, -1);
        for(int x = 0; x < data.size(); x++) {
            int finalX = x;
            Optional<ConsolidateRules> rule = rules.stream().filter(i -> i.getLeft() == data.get(finalX)).findFirst();
            if(rule.isPresent()) {
                Optional<Integer> newIndex = rule.get().getRight().stream()
                        .map(data::indexOf)
                        .filter(i -> i > -1)
                        .min(Integer::compareTo);
                if(newIndex.isEmpty()) {
                    for(int i = newData.length - 1; i >= 0; i--) {
                        if(newData[i] == -1) {
                            newData[i] = data.get(finalX);
                            break;
                        }
                    }
                } else {
                    if(newData[newIndex.get()] == -1) {
                        newData[newIndex.get()] = data.get(finalX);
                    } else if(newData[newIndex.get()] != data.get(finalX)) {
                        int tmp = newData[newIndex.get()];

                        int index = -1;
                        for(int i = 0; i < newData.length; i++) {
                            if(newData[i] == data.get(finalX)) {
                                index = i;
                                break;
                            }
                        }
                        if(index == -1) {
                            Optional<Integer> tmpVal = rule.get().getRight().stream()
                                    .map(Arrays.stream(newData).boxed().toList()::indexOf)
                                    .filter(i -> i > -1)
                                    .min(Integer::compareTo);
                            if(tmpVal.isEmpty()) {
                                for(int i = newIndex.get(); i < newData.length; i++) {
                                    if(newData[i] == -1) {
                                        index = i;
                                        break;
                                    }
                                }
                            }
                            else index = tmpVal.get();
                        }
                        newData[newIndex.get()] = data.get(finalX);
                        newData[index] = tmp;
                    }
                }
            } else {
                for(int i = newData.length - 1; i >= 0; i--) {
                    if(newData[i] == -1) {
                        newData[i] = data.get(finalX);
                        break;
                    }
                }
            }
        }
        return Arrays.stream(newData).boxed().collect(Collectors.toList());
    }

    public Integer orderCorrectlyWithCheck(ConsolidateRulesV2 rules) {
        List<Integer> newSequence = new ArrayList<>(pageData);
        for(int i = 0; i < pageData.size(); i++) {

        }
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof PageUpdate other) {
            return pageData.equals(other.pageData);
        }
        if(o instanceof int[] other) {
            boolean result = true;
            for(int i = 0; i < other.length; i++) {
                result = result && pageData.contains(other[i]);
            }
            return result;
        }
        return false;
    }
}
