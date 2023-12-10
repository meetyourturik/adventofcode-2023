package com.turik.adventofcode.day09;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day9Part1 {

    static boolean allZeros(List<Integer> nums) {
        return nums.stream().allMatch(n -> n == 0);
    }

    static int processLine(String line) {
        List<Integer> nums = Arrays.stream(line.split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> tail = new ArrayList<>();
        List<Integer> curr = nums;

        while (!allZeros(curr)) {
            tail.add(curr.get(curr.size() - 1));
            List<Integer> tmp = new ArrayList<>();
            for (int i = 1; i < curr.size(); i++) {
                tmp.add(curr.get(i) - curr.get(i - 1));
            }
            curr = tmp;
        }

        return tail.stream().reduce(0, Integer::sum);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("./inputs/day09.txt"));
        String line;
        int s = 0;
        while ((line = reader.readLine()) != null) {
            s += processLine(line);
        }
        System.out.println(s);
    }
}
