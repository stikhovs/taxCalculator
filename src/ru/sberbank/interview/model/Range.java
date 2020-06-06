package ru.sberbank.interview.model;

public class Range {

    private final double start;
    private final double end;
    private final double percent;

    public Range(double start, double end, double percent) {
        this.start = start;
        this.end = end;
        this.percent = percent;
    }

    public double getStart() {
        return start;
    }

    public double getEnd() {
        return end;
    }

    public double getPercent() {
        return percent;
    }
}
