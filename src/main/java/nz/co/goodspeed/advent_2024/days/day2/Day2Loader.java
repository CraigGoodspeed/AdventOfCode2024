package nz.co.goodspeed.advent_2024.days.day2;

import nz.co.goodspeed.advent_2024.loader.DataDayLoader;
import nz.co.goodspeed.advent_2024.loader.Days;

import java.util.Arrays;

public class Day2Loader extends DataDayLoader<Model> {
    @Override
    public Model buildType(String line) {
        Integer[] dataRaw = Arrays.stream(line.split(" ")).map(Integer::parseInt).toArray(Integer[]::new);

        Model model = new Model(dataRaw);
        return model;
    }

    @Override
    public Days getDays() {
        return Days.Day2;
    }
}
