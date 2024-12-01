package nz.co.goodspeed.advent_2024.days.Tester;

import java.util.List;

public class Runner {
    public static void main(String[] args) {
        TesterDataDayLoader tester = new TesterDataDayLoader();
        List<Model> data = tester.LoadData();

        for(Model model : data) {
            System.out.println(model);
        }
    }
}
