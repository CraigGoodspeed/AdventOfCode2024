package nz.co.goodspeed.advent_2024.days.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Runner {
    public static void main(String[] args) {
        Day1Loader loader = new Day1Loader();
        List<Model> data = loader.LoadData();
        List<Integer> left = data.stream().map(Model::left).sorted().toList();
        List<Integer> right = data.stream().map(Model::right).sorted().toList();
        int total = 0;

        int similarity = 0;

        for(int i = 0; i < left.size(); i++) {
            int result = Math.abs(left.get(i) - right.get(i));
            total += result;
            similarity += calulateSim(left.get(i), right);
        }
        //2192892
        System.out.println(total);
        System.out.println(similarity);


    }

    public static int calulateSim(int left, List<Integer> right) {
        return left * (int) right.stream().filter(i -> i == left).count();
    }
}
