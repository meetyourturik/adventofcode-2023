package com.turik.adventofcode.day01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Day1Part2 {
    static int getNumberFromLine(String line) {
        Map<Integer, String> numbers = Map.of(
                1, "one",
                2, "two",
                3, "three",
                4, "four",
                5, "five",
                6, "six",
                7, "seven",
                8, "eight",
                9, "nine"
        );

        int c1 = -1, c2 = -1,p1 = line.length() + 1, p2 = -1;

        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (Character.isDigit(c)) {
                if (c1 == -1) {
                    c1 = c - '0';
                    p1 = i;
                }
                c2 = c - '0';
                p2 = i;
            }

        }

        for (Map.Entry<Integer, String> e: numbers.entrySet()) {
            int n = e.getKey();
            String s = e.getValue();
            if (!line.contains(s)) {
                continue;
            }
            // first
            if (line.indexOf(s) < p1) {
                p1 = line.indexOf(s);
                c1 = n;
            }
            // last
            if (line.lastIndexOf(s) > p2) {
                p2 = line.lastIndexOf(s);
                c2 = n;
            }
        }

        return c1 * 10 + c2;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("./inputs/day01.txt"));
        String line;

        int s = 0;

        while ((line = reader.readLine()) != null) {
            s += getNumberFromLine(line);
        }

        System.out.println(s);
    }
}
