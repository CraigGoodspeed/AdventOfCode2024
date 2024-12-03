package nz.co.goodspeed.advent_2024.days.day2;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        Day2Loader loader = new Day2Loader();
        List<Model> data = loader.LoadData();
        int count = 0;
        for (Model model : data) {
            List<Integer> diff = model.getData();
            if (isSafe(diff)) {
                count++;
            } else {
                for (int index = 0; index < diff.size(); index++) {
                    List<Integer> tmpItem = new ArrayList<>(diff.stream().toList());
                    tmpItem.remove(index);
                    if (isSafe(tmpItem)) {
                        count++;
                        break;
                    }
                }
            }
        }
        System.out.println(count);

    }

    public static List<Integer> getDiff(List<Integer> data) {
        List<Integer> diff = new ArrayList<>();
        for (int i = 0; i < data.size() - 1; i++) {
            diff.add(data.get(i) - data.get(i + 1));
        }
        return diff;
    }

    public static boolean isSafe(List<Integer> data) {

        List<Integer> diff = getDiff(data);
        boolean allPositive =
                diff.stream().allMatch(
                        i -> i > 0
                );
        boolean allNegative =
                diff.stream().allMatch(
                        i -> i < 0
                );

        boolean noneGreaterThan3OrZero = diff.stream().allMatch(
                i -> (Math.abs(i) <= 3 && Math.abs(i) > 0)
        );

        return (allPositive || allNegative) && noneGreaterThan3OrZero;
    }
}
