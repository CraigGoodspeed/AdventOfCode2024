package nz.co.goodspeed.advent_2024.days.day3;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Runner {
    public static void main(String[] args) {
        Day3Loader loader = new Day3Loader();
        List<Model> data = loader.LoadData();
        String input = data.get(0).data();

        Pattern pattern = Pattern.compile("mul((1-3)[0-9],(1-3)[0-9])");
        Matcher matcher = pattern.matcher(input);
        if(matcher.find()) {
            do {
                System.out.println(matcher.group());
            }while(matcher.find(matcher.start()+ 1));
        }
    }
}
