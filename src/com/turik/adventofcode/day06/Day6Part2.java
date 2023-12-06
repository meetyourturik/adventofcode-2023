package com.turik.adventofcode.day06;

public class Day6Part2 {
    public static void main(String[] args) {
        int time = 46828479;
        long record = 347152214061471L;

        int count = 0;

        for (long speed = 0; speed < time; speed++) {
            if ((time - speed) * speed > record) {
                count++;
            }
        }

        System.out.println(count);
    }
}
