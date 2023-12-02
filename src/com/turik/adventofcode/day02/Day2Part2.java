package com.turik.adventofcode.day02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day2Part2 {

    // if game's impossible return 0
    static int game(String line) {
        List<String> colors = List.of(
                "red",
                "green",
                "blue"
        );
        Pattern pat = Pattern.compile("(?<count>\\d+)");

        String[] split = line.split(":");

        String[] games = split[1].trim().split(";");

        Map<String, Integer> maxes = new HashMap<>();

        for (String game: games) {
            String[] results = game.split(",");

            for (String result: results) {
                Matcher matcher = pat.matcher(result);
                matcher.find();
                int n = Integer.parseInt(matcher.group("count"));
                for (String color: colors) {
                    if (result.contains(color)) {
                        maxes.compute(color, (k, v) -> {
                            if (v == null || v < n) {
                                return n;
                            } else {
                                return v;
                            }
                        });
                    }
                }
            }
        }

        int prod = 1;
        for (int m : maxes.values()) {
            prod *= m;
        }
        return prod;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("./inputs/day02.txt"));
        String line;

        int s = 0;

        while ((line = reader.readLine()) != null) {
            s += game(line);
        }

        System.out.println(s);
    }
}
