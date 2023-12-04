package com.example.blueteammicrobenchmark;

import androidx.benchmark.BenchmarkState;
import androidx.benchmark.junit4.BenchmarkRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class StringHashCodeBenchmark {
    @Rule
    public BenchmarkRule benchmarkRule = new BenchmarkRule();

    private void measure(Runnable f) {
        BenchmarkState localState = benchmarkRule.getState();
        while(localState.keepRunningInline()) {
            f.run();
        }
    }

    private final String hashcode = "abcdefghijkl";
    private final String hashcode0 = new String(new char[]{72, 90, 100, 89, 105, 2, 72, 90, 100, 89, 105, 2});
    private final String empty = "";

    @Test
    public void cached() {
        measure(hashcode::hashCode);
    }

    @Test
    public void notCached() {
        measure(hashcode0::hashCode);
    }

    @Test
    public void empty() {
        measure(empty::hashCode);
    }
}
