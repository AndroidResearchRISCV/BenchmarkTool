package com.example.blueteammicrobenchmark;


import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import android.util.Log;

public class TestRunner {
    public static void main(String[] args) {
//        printClasspath();
//        System.loadLibrary("benchmarkNative");

        System.out.println("Loggable polyfill works: " + Log.isLoggable("asd", 1));

        Result result = JUnitCore.runClasses(StringEqualBenchmark.class);
        System.out.println("ran classes");
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        System.out.println(result.wasSuccessful());
    }


    public static boolean isLoggable(String msg, int tag) {
        return false;
    }

//    public static void printClasspath() {
//        ClassLoader cl = TestRunner.class.getClassLoader();
//
//        URL[] urls = ((PathClassLoader) cl).
//        for(URL url: urls){
//            System.out.println(url.getFile());
//        }
//    }
}
