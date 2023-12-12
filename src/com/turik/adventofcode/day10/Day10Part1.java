package com.turik.adventofcode.day10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day10Part1 {

    /* moving clockwise :
    | - going up
    - - going right
    L - going up
    J - going left
    7 - going down
    F - going right
    */
    /*
        1
        ^
    0 <- -> 2
        v
        3
     */
    // 0 - x, 1  - y, 2 - dir

    static RuntimeException SHOULDNTBEHERE = new RuntimeException("we shouldnt be here");

    static void performMove(char c, int[] pos) {
        int dir = pos[2];
        if (c == '|') {
            if (dir == 1) {
                pos[1]--;
            } else if (dir == 3) {
                pos[1]++;
            } else {
                throw SHOULDNTBEHERE;
            }
        } else if (c == '-') {
            if (dir == 0) {
                pos[0]--;
            } else if (dir == 2) {
                pos[0]++;
            } else {
                throw SHOULDNTBEHERE;
            }
        } else if (c == 'L') {
            if (dir == 0) {
                pos[1]--;
                pos[2] = 1;
            } else if (dir == 3) {
                pos[0]++;
                pos[2] = 2;
            } else {
                throw SHOULDNTBEHERE;
            }
        } else if (c == 'J') {
            if (dir == 2) {
                pos[1]--;
                pos[2] = 1;
            } else if (dir == 3) {
                pos[0]--;
                pos[2] = 0;
            } else {
                throw SHOULDNTBEHERE;
            }
        } else if (c == '7') {
            if (dir == 2) {
                pos[1]++;
                pos[2] = 3;
            } else if (dir == 1) {
                pos[0]--;
                pos[2] = 0;
            } else {
                throw SHOULDNTBEHERE;
            }
        } else if (c == 'F') {
            if (dir == 0) {
                pos[1]++;
                pos[2] = 3;
            } else if (dir == 1) {
                pos[0]++;
                pos[2] = 2;
            } else {
                throw SHOULDNTBEHERE;
            }
        } else {
            throw SHOULDNTBEHERE;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("./inputs/day10.txt"));
        String line;

        int x0 = 0;
        int y0 = 0;
        boolean foundY = false;

        List<String> lines = new ArrayList<>();

        while ((line = reader.readLine()) != null) {
            lines.add(line);
            if (line.contains("S")) {
                x0 = line.indexOf("S");
                foundY = true;
            } else if (!foundY) {
                y0++;
            }
        }

        // determined starting position pipe and
        int[] pos = new int[]{x0, y0, 1};

        int res1 = 1; // made 1 step already
        performMove('|', pos);

        while (!(pos[0] == x0 && pos[1] == y0)) {
            String currentLine = lines.get(pos[1]);

            performMove(currentLine.charAt(pos[0]), pos);
            res1++;
        }

        System.out.println("part 1: " + res1 / 2);
    }
}
