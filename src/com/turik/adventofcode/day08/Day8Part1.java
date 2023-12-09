package com.turik.adventofcode.day08;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day8Part1 {
    public static void main(String[] args) throws IOException {
        String instructions = "LRRLRRLRRRLRLLRRRLLRRRLRLRRRLRLRRLRRRLRRRLRLRRRLRRRLRRLRRRLLLRLRRRLRRRLRRRLRLRLRRLLRRRLRLLRLRRRLRRLLRLRLRRLRRRLRRLLRLRRRLLRRLRRRLRLRRLLRRRLRRLLRRLRRRLRLRRRLRRLRRRLRRRLRRLRRRLRLRRLRRRLRRRLRRLLRLRRLRRLRRRLRLLLRRRLLRRRLRLRRRLRLRRLRRRLLLRLRRRLRLRRLRRRLRRRLRRLRLRLRRRR";

        BufferedReader reader = new BufferedReader(new FileReader("./inputs/day08.txt"));
        String line;
        Pattern pat = Pattern.compile("(?<c0>\\w{3})\\s=\\s\\((?<c1>\\w{3}),\\s(?<c2>\\w{3})\\)");
        Map<String, String[]> maps = new HashMap<>();

        while ((line = reader.readLine()) != null) {
            Matcher matcher = pat.matcher(line);
            matcher.find();
            String c0 = matcher.group("c0");
            String c1 = matcher.group("c1");
            String c2 = matcher.group("c2");

            maps.put(c0, new String[]{c1, c2});
        }

        int step = 0;

        String curr = "AAA";

        while (!curr.equals("ZZZ")) {
            char ins = instructions.charAt(step++ % instructions.length());
            int take = ins == 'L' ? 0 : 1;
            curr = maps.get(curr)[take];
        }

        System.out.println(step);
    }
}
