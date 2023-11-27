# RISC-V Benchmark Tool

How to run:

```shell
# Build APK
./gradlew :microbenchmarks:createReleaseAndroidTestApkListingFileRedirect
# Install APK
adb install  microbenchmarks/build/outputs/apk/androidTest/release/microbenchmarks-release-androidTest.apk
# Run APK
adb shell am instrument -w -e "androidx.benchmark.suppressErrors" "EMULATOR,LOW-BATTERY" com.example.blueteammicrobenchmark.test/androidx.benchmark.junit4.AndroidBenchmarkRunner
# Download results
adb pull /storage/emulated/0/Android/media/com.example.blueteammicrobenchmark.test/com.example.blueteammicrobenchmark.test-benchmarkData.json path/to/output.json
```
