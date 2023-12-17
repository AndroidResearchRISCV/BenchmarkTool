plugins {
    id("com.android.library")
    id("kotlin-android")
    id("androidx.benchmark")
}

android {
    compileSdk = 34

    defaultConfig {
        minSdk = 34
        targetSdk = 34

        // Set this argument to capture profiling information, instead of measuring performance.
        // Can be one of:
        //   * None
        //   * StackSampling
        //   * MethodTracing
        // See full descriptions of available options at: d.android.com/benchmark#profiling
        testInstrumentationRunnerArguments["androidx.benchmark.profiling.mode"] = "StackSampling"
        testInstrumentationRunnerArguments["androidx.benchmark.suppressErrors"] = "EMULATOR,LOW-BATTERY"
    }

    testBuildType = "release"

    buildTypes {
        getByName("release") {
            // The androidx.benchmark plugin configures release buildType with proper settings, such as:
            // - disables code coverage
            // - adds CPU clock locking task
            // - signs release buildType with debug signing config
            // - copies benchmark results into build/outputs/connected_android_test_additional_output folder
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }

    namespace = "com.example.blueteammicrobenchmark"
    experimentalProperties["android.experimental.self-instrumenting"] = true
}

dependencies {
    implementation(libs.benchmark)
//    implementation(libs.test.ext)
    implementation(libs.test.rules)
    implementation(libs.test.runner)
//    implementation(libs.junit)

//    implementation(fileTree("/Users/furetur/projects/uni/RiscArtBenchmarkTool/deps/junit4-r4.13.2/src"))
    implementation(libs.kotlin.stdlib)
    implementation("org.hamcrest:hamcrest-core:1.3")
    implementation("org.hamcrest:hamcrest-library:1.3")
}

configurations.all {
    exclude("junit", "junit")
    exclude("androidx.test.ext:junit:1.1.5")
}
