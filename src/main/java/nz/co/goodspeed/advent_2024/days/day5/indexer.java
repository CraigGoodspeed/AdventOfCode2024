package nz.co.goodspeed.advent_2024.days.day5;

import java.util.Objects;

public class indexer {
    int value;
    int index;

    public indexer(int value, int index) {
        this.value = value;
        this.index = index;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

}
