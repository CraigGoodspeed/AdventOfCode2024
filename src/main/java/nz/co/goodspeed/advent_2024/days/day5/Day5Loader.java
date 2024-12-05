package nz.co.goodspeed.advent_2024.days.day5;

import nz.co.goodspeed.advent_2024.loader.DataDayLoader;
import nz.co.goodspeed.advent_2024.loader.Days;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import static nz.co.goodspeed.advent_2024.loader.Days.Day5;

public class Day5Loader  {

    public Model buildType() {
        ArrayList<Rule> rules = new ArrayList<>();
        ArrayList<PageUpdate> pageUpdates = new ArrayList<>();
        Scanner scanner = new Scanner(
                Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream(Day5.getPath()))
        );
        boolean loadPages = false;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if(loadPages) {
                pageUpdates.add(new PageUpdate(line));
            }
            else if(!line.isEmpty()) {
                rules.add(new Rule(line));
            } else {
                loadPages = true;
            }
        }
        return new Model(rules, pageUpdates);
    }


}
