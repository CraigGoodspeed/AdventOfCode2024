package nz.co.goodspeed.advent_2024.days.day2;

import java.util.Arrays;
import java.util.List;

public record Model(Integer[] levels) {

    public List<Integer> getData() {
        return Arrays.asList(levels);
    }
}
