package com.turik.adventofcode.day05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day5Test {

    static List<Almanac> parseMap(List<long[]> maps) {
        List<Almanac> res = new ArrayList<>();
        for (long[] map: maps) {
            res.add(new Almanac(map[1], map[0], map[2]));
        }
        return res;
    }

    static long getNext(List<Almanac> almanacs, long source) {
        for (Almanac almanac: almanacs) {
            if (almanac.fits(source)) {
                return almanac.getDestN(source);
            }
        }
        return source;
    }

    public static void main(String[] args) {
        long[] seeds = new long[]{79, 14, 55, 13};

        List<long[]> seedToSoilMap = List.of(
            new long[]{50, 98, 2},
            new long[]{52, 50, 48}
        );

        List<long[]> soilToFertMap = List.of(
                new long[]{0, 15, 37},
                new long[]{37, 52, 2},
                new long[]{39, 0, 15}
        );

        List<long[]> fertToWaterMap = List.of(
                new long[]{49, 53, 8},
                new long[]{0, 11, 42},
                new long[]{42, 0, 7},
                new long[]{57, 7, 4}
        );

        List<long[]> waterToLightMap = List.of(
                new long[]{88, 18, 7},
                new long[]{18, 25, 70}
        );

        List<long[]> lightToTempMap = List.of(
                new long[]{45, 77, 23},
                new long[]{81, 45, 19},
                new long[]{68, 64, 13}
        );

        List<long[]> tempToHumMap = List.of(
                new long[]{0, 69, 1},
                new long[]{1, 0, 69}
        );

        List<long[]> humToLocMap = List.of(
                new long[]{60, 56, 37},
                new long[]{56, 93, 4}
        );

        List<List<long[]>> maps = List.of(
                seedToSoilMap,
                soilToFertMap,
                fertToWaterMap,
                waterToLightMap,
                lightToTempMap,
                tempToHumMap,
                humToLocMap
        );

        List<List<Almanac>> almanacs = new ArrayList<>();

        for (List<long[]> map: maps) {
            almanacs.add(parseMap(map));
        }

        for (int i = 0; i < seeds.length; i++) {
            for (List<Almanac> almanac: almanacs) {
                seeds[i] = getNext(almanac, seeds[i]);
            }
        }

        System.out.println(Arrays.toString(seeds));

    }
}
