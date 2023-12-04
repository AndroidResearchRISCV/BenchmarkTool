package com.example.blueteammicrobenchmark;

import androidx.benchmark.BenchmarkState;
import androidx.benchmark.junit4.BenchmarkRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class StringSubstringBenchmark {
    @Rule
    public BenchmarkRule benchmarkRule = new BenchmarkRule();

    public String s = "An arbitrary string that happened to be of length 52";

    private void measure(Runnable f) {
        BenchmarkState localState = benchmarkRule.getState();
        while(localState.keepRunningInline()) {
            f.run();
        }
    }

    @Test
    public void from26toEnd0() {
        measure(() -> s.substring(26));
    }

    @Test
    public void from26toEnd1() {
        measure(() -> s.substring(26, s.length()));
    }

    @Test
    public void empty() {
        measure(() -> s.substring(17, 17));
    }
}
