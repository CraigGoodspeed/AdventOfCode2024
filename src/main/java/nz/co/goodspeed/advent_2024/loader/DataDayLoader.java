package nz.co.goodspeed.advent_2024.loader;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public abstract class DataDayLoader<T> {
    public List<T> LoadData() {
        Scanner scanner = new Scanner(
                Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream(getDays().getPath()))
        );
        List<T> data = new ArrayList<>();
        while (scanner.hasNextLine()) {
            T item = buildType(scanner.nextLine());
            data.add(item);
        }
        return data;
    }

    public abstract T buildType(String line);
    public abstract Days getDays();
}
