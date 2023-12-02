package com.turik.adventofcode.day02;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day2Part1 {

    // if game's impossible return 0
    static int game(String line) {
        Map<String, Integer> limits = Map.of(
                "red", 12,
                "green", 13,
                "blue", 14
        );
        Pattern pat = Pattern.compile("(?<count>\\d+)");

        String[] split = line.split(":");
        int gameId = Integer.parseInt(split[0].split(" ")[1]);
        String[] games = split[1].trim().split(";");

        for (String game: games) {
            String[] results = game.split(",");
            for (String result: results) {
                Matcher matcher = pat.matcher(result);
                matcher.find();
                int n = Integer.parseInt(matcher.group("count"));
                for (Map.Entry<String, Integer> limit: limits.entrySet()) {
                    if (result.contains(limit.getKey()) && n > limit.getValue()) {
                        return 0;
                    }
                }
            }
        }

        return gameId;
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
