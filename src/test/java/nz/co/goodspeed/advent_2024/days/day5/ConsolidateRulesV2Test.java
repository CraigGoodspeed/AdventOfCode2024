package nz.co.goodspeed.advent_2024.days.day5;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.List;

public class ConsolidateRulesV2Test extends TestCase {

    @Test
    public void testConsolidateRules() {
        ConsolidateRulesV2 v2 = new ConsolidateRulesV2(
                List.of(
                        new Rule(5,2),
                        new Rule(2,6),
                        new Rule(2,4),
                        new Rule(7,1),
                        new Rule(2,1)
                )

        );
    }

}