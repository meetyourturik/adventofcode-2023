package com.turik.adventofcode.day12;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Day12Part1 {

    static String mapToPos(String springs, String pos, List<Integer> qps) {
        String res = springs;
        for (int i = 0; i < pos.length(); i++) {
            if (pos.charAt(i) == '1') {
                res = res.substring(0, qps.get(i)) + '#' + res.substring(qps.get(i) + 1);
            } else {
                res = res.substring(0, qps.get(i)) + '.' + res.substring(qps.get(i) + 1);
            }
        }
        return res;
    }

    static List<Integer> getGroups(String springs) {
        List<Integer> res = new ArrayList<>();
        int count = 0;
        for (char c: springs.toCharArray()) {
            if (c == '#') {
                count++;
            } else if (count != 0) {
                res.add(count);
                count = 0;
            }
        }
        if (count != 0) {
            res.add(count);
        }
        return res;
    }

    static int processLine(String line) {
        String[] split = line.split(" ");
        String springs = split[0];

        AtomicInteger nSprings = new AtomicInteger(0);
        List<Integer> groups = Arrays.stream(split[1].split(","))
                .map(Integer::parseInt)
                .peek(nSprings::addAndGet)
                .collect(Collectors.toList());

        List<Integer> qps = new ArrayList<>();
        int setSprings = 0;

        for (int i = 0; i < springs.length(); i++) {
            if (springs.charAt(i) == '?') {
                qps.add(i);
            } else if (springs.charAt(i) == '#') {
                setSprings--;
            }
        }

        nSprings.addAndGet(setSprings);

        int res = 0;
        int max = (int) Math.pow(2, qps.size());
        String format = "%1$" + qps.size() + "s";
        for (int i = 0; i < max; i++) {
            int potSprings = Integer.bitCount(i);
            if (potSprings != nSprings.get()) {
                continue;
            }
            String tmp = mapToPos(springs, String.format(format, Integer.toBinaryString(i)), qps);
            if (groups.equals(getGroups(tmp))) {
                res++;
            }
        }

        return res;
    }

    // brute force wouldn't work for part 2
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("./inputs/day12.txt"));
        String line;

        int res = 0;

        while ((line = reader.readLine()) != null) {
            res += processLine(line);
        }

        System.out.println(res);
    }
}
