package nz.co.goodspeed.advent_2024.days.day4;

import nz.co.goodspeed.advent_2024.loader.DataDayLoader;
import nz.co.goodspeed.advent_2024.loader.Days;

public class Day4Loader extends DataDayLoader<Model> {
    @Override
    public Model buildType(String line) {
        return new Model(line);
    }

    @Override
    public Days getDays() {
        return Days.Day4;
    }
}
