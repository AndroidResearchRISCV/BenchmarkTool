package com.example.blueteammicrobenchmark

import androidx.benchmark.junit4.BenchmarkRule
import androidx.benchmark.junit4.measureRepeated
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class SampleBenchmark {
    @get:Rule
    val benchmarkRule = BenchmarkRule()

    private val str1 = getRandomString(50)

    private fun getRandomString(length: Int) : String {
        val charset = "ABCDEFGHIJKLMNOPQRSTUVWXTZabcdefghiklmnopqrstuvwxyz0123456789"
        return (1..length)
            .map { charset.random() }
            .joinToString("")
    }

    @Test
    fun equalStrings() {
        val str2 = str1
        benchmarkRule.measureRepeated {
            assertTrue(str1.equals(str2))
        }
    }

    @Test
    fun notEqualStringsWithSameLength() {
        val str2 = getRandomString(50)
        benchmarkRule.measureRepeated {
            assertFalse(str1.equals(str2))
        }
    }

    @Test
    fun notEqualStringsWithDifferentLength() {
        val str2 = getRandomString(100)
        benchmarkRule.measureRepeated {
            assertFalse(str1.equals(str2))
        }
    }
}