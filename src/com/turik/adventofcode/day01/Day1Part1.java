package com.turik.adventofcode.day01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day1Part1 {
    static int getNumberFromLine(String line) {
        int c1 = -1;
        int c2 = -1;

        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (Character.isDigit(c)) {
                if (c1 == -1) {
                    c1 = c - '0';
                }
                c2 = c - '0';
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
