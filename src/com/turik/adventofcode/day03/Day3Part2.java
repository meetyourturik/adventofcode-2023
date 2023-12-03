package com.turik.adventofcode.day03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Day3Part2 {
    static boolean isGear(char c) {
        return c == '*';
    }

    static int getAdjacentGearPos(String s, int from, int to) {
        int res = -1;
        for (int i = Math.max(from, 0); i <= Math.min(s.length() - 1, to); i++) {
            if (isGear(s.charAt(i))) {
                res = i;
            }
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        List<String> engine = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader("./inputs/day03.txt"));
        String line;
        while ((line = reader.readLine()) != null) {
            engine.add(line);
        }

        Map<Gear, Set<String>> m = new HashMap<>();

        for (int i = 0; i < engine.size(); i++) {
            String curr = engine.get(i);
            for (int j = 0; j < curr.length(); j++) {
                char c = curr.charAt(j);
                if (Character.isDigit(curr.charAt(j))) {
                    int pos = j;
                    StringBuilder sb = new StringBuilder();
                    while (j < curr.length() && Character.isDigit(curr.charAt(j))) {
                        sb.append(curr.charAt(j++));
                    }
                    String ns = sb.toString();
                    String uniquen = i+":"+j+":"+ns;
                    int n = Integer.parseInt(ns);
                    // checking if there's an adjacent gear
                    int ag = -1;
                    if ((ag = getAdjacentGearPos(curr, pos - 1, pos + ns.length())) != -1) {
                        Gear g = new Gear(i, ag);
                        Set<String> s = m.compute(g, (k, v) -> v != null ? v : new HashSet<>());
                        s.add(uniquen);
                    }
                    ag = -1;
                    if (i > 0 && (ag = getAdjacentGearPos(engine.get(i-1), pos - 1, pos + ns.length())) != -1) {
                        Gear g = new Gear(i-1, ag);
                        Set<String> s = m.compute(g, (k, v) -> v != null ? v : new HashSet<>());
                        s.add(uniquen);
                    }
                    ag = -1;
                    if (i < (engine.size() - 1) && (ag = getAdjacentGearPos(engine.get(i+1), pos - 1, pos + ns.length())) != -1) {
                        Gear g = new Gear(i+1, ag);
                        Set<String> s = m.compute(g, (k, v) -> v != null ? v : new HashSet<>());
                        s.add(uniquen);
                    }
                }
            }
        }

        int s = 0;

        for (Set<String> subs: m.values()) {
            if (subs.size() == 2) {
                int prod = 1;
                for (String str: subs) {
                    prod *= Integer.parseInt(str.split(":")[2]);
                }
                s += prod;
            }
        }

        System.out.println(s);
    }
}
