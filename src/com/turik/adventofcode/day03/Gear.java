package com.turik.adventofcode.day03;

public class Gear {
    public int x;
    public int y;

    public Gear(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Gear gear = (Gear) o;

        if (x != gear.x) return false;
        return y == gear.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}
