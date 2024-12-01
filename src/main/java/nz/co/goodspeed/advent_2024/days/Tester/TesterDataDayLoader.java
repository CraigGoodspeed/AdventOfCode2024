package nz.co.goodspeed.advent_2024.days.Tester;

import nz.co.goodspeed.advent_2024.loader.DataDayLoader;
import nz.co.goodspeed.advent_2024.loader.Days;

public class TesterDataDayLoader extends DataDayLoader<Model> {
    @Override
    public Model buildType(String line) {
        String[] parts = line.split(",");
        return new Model(
                parts[0],
                parts[1],
                Integer.parseInt(parts[2])
        );
    }

    @Override
    public Days getDays() {
        return Days.Tester;
    }


}
