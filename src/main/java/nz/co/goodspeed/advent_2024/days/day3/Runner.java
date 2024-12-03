package nz.co.goodspeed.advent_2024.days.day3;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Runner {
    public static void main(String[] args) throws IOException {
        Day3Loader loader = new Day3Loader();
        List<Model> data = loader.LoadData();
        String regex = new String(Runner.class.getClassLoader().getResourceAsStream("regex.txt").readAllBytes(), StandardCharsets.UTF_8);
        Pattern pattern = Pattern.compile(regex);
        List<Equation> items = new ArrayList<>();
        boolean enabled = true;
        for(Model model : data) {
            Matcher matcher = pattern.matcher(model.data());
            while (matcher.find()) {
                String val = matcher.group(0);
                if (val.equals("do()")) {
                    enabled = true;
                } else if (val.equals("don't()")) {
                    enabled = false;
                } else {
                    if (enabled) {
                        items.add(new Equation(val));
                    }
                }
            }
        }
//59162863
//58347230
//62098619

        items.stream().map(Equation::doMath).reduce(Long::sum).ifPresent(System.out::println);
    }
}
