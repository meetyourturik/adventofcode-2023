package com.turik.adventofcode.day04;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day4Part2 {

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

        return count;
    }

    public static void main(String[] args) throws IOException {
        int[] res = new int[197];
        BufferedReader reader = new BufferedReader(new FileReader("./inputs/day04.txt"));
        String line;
        int i = 0;
        while ((line = reader.readLine()) != null) {
            res[i]++;
            int w = calcLine(line);
            for (int j = i+1; j <= Math.min(i+w, res.length - 1); j++) {
                res[j] += res[i];
            }
            i++;
        }
        int s = 0;
        for (int r: res) {
            s += r;
        }
        System.out.println(s);
    }
}
