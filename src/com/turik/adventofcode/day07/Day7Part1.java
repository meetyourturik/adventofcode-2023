package com.turik.adventofcode.day07;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Day7Part1 {

    public static void main(String[] args) throws IOException {
        long s = 0;
        BufferedReader reader = new BufferedReader(new FileReader("./inputs/day07.txt"));
        String line;
        List<Bid> bids = new ArrayList<>();
        while ((line = reader.readLine()) != null) {
            bids.add(new Bid(line));
        }
        bids.sort(Comparator.reverseOrder());
        for (int i = 0; i < bids.size(); i++) {
            s += (i + 1) * bids.get(i).bid;
        }

        System.out.println(s);
    }
}
