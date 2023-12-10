package com.turik.adventofcode.day08;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day8Part2 {

    static long gcd(long a,long b){
        return b == 0 ? a : gcd(b,a % b);
    }

    static long lcm(long a, long b){
        return a / gcd(a,b) * b;
    }

    public static void main(String[] args) throws IOException {
        String instructions = "LRRLRRLRRRLRLLRRRLLRRRLRLRRRLRLRRLRRRLRRRLRLRRRLRRRLRRLRRRLLLRLRRRLRRRLRRRLRLRLRRLLRRRLRLLRLRRRLRRLLRLRLRRLRRRLRRLLRLRRRLLRRLRRRLRLRRLLRRRLRRLLRRLRRRLRLRRRLRRLRRRLRRRLRRLRRRLRLRRLRRRLRRRLRRLLRLRRLRRLRRRLRLLLRRRLLRRRLRLRRRLRLRRLRRRLLLRLRRRLRLRRLRRRLRRRLRRLRLRLRRRR";

        BufferedReader reader = new BufferedReader(new FileReader("./inputs/day08.txt"));
        String line;
        Pattern pat = Pattern.compile("(?<c0>\\w{3})\\s=\\s\\((?<c1>\\w{3}),\\s(?<c2>\\w{3})\\)");
        Map<String, String[]> maps = new HashMap<>();
        List<String> positions = new ArrayList<>();
        while ((line = reader.readLine()) != null) {
            Matcher matcher = pat.matcher(line);
            matcher.find();
            String c0 = matcher.group("c0");
            String c1 = matcher.group("c1");
            String c2 = matcher.group("c2");

            maps.put(c0, new String[]{c1, c2});
            if (c0.endsWith("A")) {
                positions.add(c0);
            }
        }

        long res = 1L;

        for (String curr: positions) {
            int step = 0;
            while (!curr.endsWith("Z")) {
                char ins = instructions.charAt(step++ % instructions.length());
                int take = ins == 'L' ? 0 : 1;
                curr = maps.get(curr)[take];
            }
            res = lcm(res, step);
        }

        System.out.println(res);
    }
}
