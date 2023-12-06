package com.turik.adventofcode.day06;

public class Day6Part1 {
    public static void main(String[] args) {
        int[] times = {46, 82, 84, 79};
        int[] distances = {347, 1522, 1406, 1471};

        int[] ps = new int[times.length];

        for (int i = 0; i < times.length; i++) {
            for (int speed = 0; speed < times[i]; speed++) {
                if ((times[i] - speed) * speed > distances[i]) {
                    ps[i]++;
                }
            }
        }
        int prod = 1;
        for (int p: ps) {
            prod *= p;
        }

        System.out.println(prod);
    }
}
