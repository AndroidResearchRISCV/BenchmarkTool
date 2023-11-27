package com.example.blueteammicrobenchmark;

import androidx.benchmark.BenchmarkState;
import androidx.benchmark.junit4.BenchmarkRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class ArrayCopyBenchmark {
    @Rule
    public BenchmarkRule benchmarkRule = new BenchmarkRule();

    int[] array1 = {5, 9, -3, 10, 0, 8, 256, 127, 34, -19, -14, 35, 39, 98, 354, -99};

    private void measure(Runnable f) {
        BenchmarkState localState = benchmarkRule.getState();
        while(localState.keepRunningInline()) {
            f.run();
        }
    }

    @Test
    public void copyArray() {
        int[] array2 = new int[16];

        measure(() -> {
            System.arraycopy(array1, 0, array2, 0, 16);
        });
    }
}
