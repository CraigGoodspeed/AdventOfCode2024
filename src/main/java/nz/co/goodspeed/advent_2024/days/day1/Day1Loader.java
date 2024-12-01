package nz.co.goodspeed.advent_2024.days.day1;

import nz.co.goodspeed.advent_2024.loader.DataDayLoader;
import nz.co.goodspeed.advent_2024.loader.Days;

public class Day1Loader extends DataDayLoader<Model> {
    @Override
    public Model buildType(String line) {
        String[] dataRaw = line.split("   ");
        Model model = new Model(Integer.parseInt(dataRaw[0]), Integer.parseInt(dataRaw[1]));
        return model;
    }

    @Override
    public Days getDays() {
        return Days.Day1;
    }
}
