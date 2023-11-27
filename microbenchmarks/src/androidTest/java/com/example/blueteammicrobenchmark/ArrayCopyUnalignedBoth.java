package com.example.blueteammicrobenchmark;

import androidx.benchmark.BenchmarkState;
import androidx.benchmark.junit4.BenchmarkRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Random;

@RunWith(AndroidJUnit4.class)
public class ArrayCopyUnalignedBoth {
    @Rule
    public BenchmarkRule benchmarkRule = new BenchmarkRule();

    int length = 310;

    // Both positions unaligned
    int fromPos = 9;
    int toPos = 10;
    char[] fromCharArr = new char[length];
    int[] fromIntArr = new int[length];
    long[] fromLongArr = new long[length];

    private void measure(Runnable f) {
        BenchmarkState localState = benchmarkRule.getState();
        while(localState.keepRunningInline()) {
            f.run();
        }
    }

    @Test
    public void testChar() {
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            fromCharArr[i] = (char)(random.nextInt(26) + 'a');
        }
        char[] toCharArr = new char[length];

        measure(() -> System.arraycopy(fromCharArr, fromPos, toCharArr, toPos, length-10));
    }

    @Test
    public void testInt() {
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            fromIntArr[i] = random.nextInt();
        }
        int[] toIntArr = new int[length];

        measure(() -> System.arraycopy(fromIntArr, fromPos, toIntArr, toPos, length-10));
    }

    @Test
    public void testLong() {
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            fromLongArr[i] = random.nextLong();
        }
        long[] toLongArr = new long[length];

        measure(() -> System.arraycopy(fromLongArr, fromPos, toLongArr, toPos, length-10));
    }
}
