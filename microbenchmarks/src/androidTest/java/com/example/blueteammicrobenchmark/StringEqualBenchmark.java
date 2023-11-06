package com.example.blueteammicrobenchmark;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import androidx.benchmark.BenchmarkState;
import androidx.benchmark.junit4.BenchmarkRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class StringEqualBenchmark {
    @Rule
    public BenchmarkRule benchmarkRule = new BenchmarkRule();

    String str1 = "A3jtgdGH345678ikjhgfdxcvbn";

//    private String getRandomString(int length) {
//        var charset = "ABCDEFGHIJKLMNOPQRSTUVWXTZabcdefghiklmnopqrstuvwxyz0123456789";
//        return (1..length)
//                .map { charset.random() }
//            .joinToString("")
//    }

    private void measure(Runnable f) {
        BenchmarkState localState = benchmarkRule.getState();
        while(localState.keepRunningInline()) {
            f.run();
        }
    }

    @Test
    public void equalStrings() {
        String str2 = str1;

        measure(() -> {
            str1.equals(str2);
        });
    }

//    @Test
//    void notEqualStringsWithSameLength() {
//        var str2 = getRandomString(50);
//        benchmarkRule.measureRepeated {
//            assertFalse(str1.equals(str2))
//        }
//    }
//
//    @Test
//    void notEqualStringsWithDifferentLength() {
//        var str2 = getRandomString(100);
//        benchmarkRule.measureRepeated {
//            assertFalse(str1.equals(str2))
//        }
//    }
}
