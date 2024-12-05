package nz.co.goodspeed.advent_2024.days.day5;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        Day5Loader loader = new Day5Loader();
        Model data = loader.buildType();
        ConsolidateRulesV2 consolidateRulesV2 = new ConsolidateRulesV2(data.rules());
        /*
        List<ConsolidateRules> consolidateRules = new ArrayList<>();

        for(Rule item: data.rules()) {
            if(consolidateRules.stream().noneMatch(
                    i -> i.getLeft() == item.first
            )) {
                consolidateRules.add(new ConsolidateRules(item.getFirst(), data.rules()));
            }
        }
        */




        int total = 0;
        int part2Total = 0;
        for(PageUpdate page : data.pages()) {
            int middle = (page.pageData.size()/2);
            if(page.isOrderedCorrectly(data.rules())) {
                total += page.pageData.get(middle);
            } else {
                part2Total +=   page.orderCorrectlyWithCheck(consolidateRulesV2);
            }
        }

        System.out.println("Part 1: "+total);

        System.out.println("Part 2: "+part2Total);
        System.out.println(consolidateRulesV2);
    }


}
