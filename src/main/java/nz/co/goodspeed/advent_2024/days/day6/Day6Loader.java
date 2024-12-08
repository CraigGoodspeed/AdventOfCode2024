package nz.co.goodspeed.advent_2024.days.day6;

import nz.co.goodspeed.advent_2024.loader.DataDayLoader;
import nz.co.goodspeed.advent_2024.loader.Days;

public class Day6Loader extends DataDayLoader<Model> {
    @Override
    public Model buildType(String line) {
        Model model = new Model(line);
        return model;
    }

    @Override
    public Days getDays() {
        return Days.Day6;
    }
}
