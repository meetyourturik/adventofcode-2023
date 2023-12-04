package com.turik.adventofcode.day04;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day4Part1 {

    static int calcLine(String line) {
        String[] s1 = line.split(":")[1].split("\\|");
        List<Integer> have = Arrays.stream(s1[0].trim().split(" ")).filter(s -> !s.isBlank()).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> winning = Arrays.stream(s1[1].trim().split(" ")).filter(s -> !s.isBlank()).map(Integer::parseInt).collect(Collectors.toList());
        int count = 0;

        for (Integer h: have) {

            if (winning.contains(h)) {
                count++;
            }
        }

        return count > 0 ? (int) Math.pow(2, count - 1) : 0;
    }

    public static void main(String[] args) throws IOException {
        int s = 0;
        BufferedReader reader = new BufferedReader(new FileReader("./inputs/day04.txt"));
        String line;
        while ((line = reader.readLine()) != null) {
            s += calcLine(line);
        }
        System.out.println(s);
    }
}
