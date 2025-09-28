package org.example;

import java.util.concurrent.atomic.AtomicInteger;

public class Metrics {
    public AtomicInteger comparisons = new AtomicInteger();
    public AtomicInteger allocations = new AtomicInteger();
    private int depth = 0;
    private int maxDepth = 0;

    private long startTime = 0;
    private long elapsedTime = 0;

    public Metrics() {}

    public void compare() {
        this.comparisons.incrementAndGet();
    }

    public void allocate() {
        this.allocations.incrementAndGet();
    }

    public void enter() {
        ++this.depth;
        if (this.depth > this.maxDepth) {
            this.maxDepth = this.depth;
        }
    }

    public void exit() {
        --this.depth;
    }

    public void startTimer() {
        this.startTime = System.nanoTime();
    }

    public void stopTimer() {
        this.elapsedTime = System.nanoTime() - this.startTime;
    }

    public int getComparisons() {
        return this.comparisons.get();
    }

    public int getAllocations() {
        return this.allocations.get();
    }

    public int getMaxDepth() {
        return this.maxDepth;
    }

    public long getElapsedTime() {
        return this.elapsedTime;
    }

    public void reset() {
        comparisons.set(0);
        allocations.set(0);
        depth = 0;
        maxDepth = 0;
        startTime = 0;
        elapsedTime = 0;
    }

    public String toCSV(String algoName, int n) {
        return algoName + "," + n + "," + getComparisons() + "," +
                getAllocations() + "," + getMaxDepth() + "," + getElapsedTime();
    }
}