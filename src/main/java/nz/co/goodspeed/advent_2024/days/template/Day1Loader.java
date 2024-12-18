package nz.co.goodspeed.advent_2024.days.template;

import nz.co.goodspeed.advent_2024.loader.DataDayLoader;
import nz.co.goodspeed.advent_2024.loader.Days;

public class Day1Loader extends DataDayLoader<Model> {
    @Override
    public Model buildType(String line) {
        String[] dataRaw = line.split(",");
        Model model = new Model(dataRaw[0]);
        return model;
    }

    @Override
    public Days getDays() {
        return Days.Day1;
    }
}
