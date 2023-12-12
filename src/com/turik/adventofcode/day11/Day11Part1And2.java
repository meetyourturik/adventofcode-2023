package com.turik.adventofcode.day11;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Day11Part1And2 {

    static void addPositions(String line, Set<Integer> galaxieX) {
        int pos = line.indexOf('#');
        while (pos != -1) {
            galaxieX.add(pos);
            pos = line.indexOf('#', pos + 1);
        }
    }

    static void addGalaxies(String line, int lineN, List<int[]> galaxies) {
        int pos = line.indexOf('#');
        while (pos != -1) {
            galaxies.add(new int[]{pos, lineN});
            pos = line.indexOf('#', pos + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("./inputs/day11.txt"));
        String line;

        Set<Integer> galaxieX = new HashSet<>();
        Set<Integer> galaxieY = new HashSet<>();
        List<int[]> galaxies = new ArrayList<>();
        int lineN = 0;

        while ((line = reader.readLine()) != null) {
            if (line.indexOf('#') == -1) {
                galaxieY.add(lineN);
            } else {
                addPositions(line, galaxieX);
                addGalaxies(line, lineN, galaxies);
            }
            lineN++;
        }

        long res1 = 0;
        long res2 = 0;

        for (int i = 0; i < galaxies.size() - 1; i++) {
            int[] gal1 = galaxies.get(i);
            for (int j = i+1; j < galaxies.size(); j++) {
                int[] gal2 = galaxies.get(j);
                int dist, dist2 = (dist = Math.abs(gal1[0] - gal2[0]) + Math.abs(gal1[1] - gal2[1]));
                // accounting for horizontal expansion
                for (int h = Math.min(gal1[0], gal2[0]); h <= Math.max(gal1[0], gal2[0]); h++) {
                    if (!galaxieX.contains(h)) {
                        dist += 1;
                        dist2 += 1000000 - 1;
                    }
                }
                // accounting for vertical expansion
                for (int v = Math.min(gal1[1], gal2[1]); v <= Math.max(gal1[1], gal2[1]); v++) {
                    if (galaxieY.contains(v)) {
                        dist += 1;
                        dist2 += 1000000 - 1;
                    }
                }
                res1 += dist;
                res2 += dist2;
            }
        }

        System.out.println("part1: " + res1);
        System.out.println("part2: " + res2);
    }
}
