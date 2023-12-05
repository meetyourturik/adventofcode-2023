package com.turik.adventofcode.day05;

public class Almanac {
    long sourceStart;
    long destStart;
    long length;

    public Almanac(long sourceStart, long destStart, long length) {
        this.sourceStart = sourceStart;
        this.destStart = destStart;
        this.length = length;
    }

    public boolean fits(long sourceN) {
        return sourceN >= sourceStart && sourceN < sourceStart + length;
    }

    public long getDestN(long sourceN) {
        return (sourceN - sourceStart) + destStart;
    }
}
