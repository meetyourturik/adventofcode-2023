package com.turik.adventofcode.day03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day3Part1 {
    static boolean isSymbol(char c) {
        return c != '.' && !Character.isDigit(c);
    }

    static boolean hasSymbol(String s, int from, int to) {
        boolean res = false;
        for (int i = Math.max(from, 0); i <= Math.min(s.length() - 1, to); i++) {
            res |= isSymbol(s.charAt(i));
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
        int s = 0;

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
                    int n = Integer.parseInt(ns);
                    // checking if it's a "part number"
                    boolean sameCheck = hasSymbol(curr, pos - 1, pos + ns.length());
                    boolean prevCheck = i > 0 && hasSymbol(engine.get(i-1), pos - 1, pos + ns.length());
                    boolean nextCheck = i < (engine.size() - 1) && hasSymbol(engine.get(i+1), pos - 1, pos + ns.length());
                    if (sameCheck || prevCheck || nextCheck) {
                        s += n;
                    }
                }
            }
        }
        System.out.println(s);
    }
}
