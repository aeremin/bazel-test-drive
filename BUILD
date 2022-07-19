load("//:kotlin.bzl", "kt_jvm_binary", "kt_jvm_test")
load("@rules_jvm_external//:defs.bzl", "artifact")

java_library(
    name = "greeter",
    srcs = ["Greeting.java"],
)

kt_jvm_binary(
    name = "example",
    srcs = ["Example.kt"],
    deps = [
        ":greeter"
    ],
    main_class = "com.example.ExampleKt"
)

kt_jvm_test(
    name = "example_test",
    srcs = [
        "ExampleTest.kt",
    ],
    test_class = "com.example.ExampleTest",
    deps = [
        "@maven//:junit_junit",
    ],
)

kt_jvm_binary(
    name = "server",
    srcs = ["Server.kt"],
    deps = [
        artifact("io.ktor:ktor-server-netty-jvm"),
        artifact("io.ktor:ktor-server-core-jvm"),
        artifact("io.ktor:ktor-server-host-common-jvm"),
        artifact("io.ktor:ktor-http-jvm"),
        artifact("io.ktor:ktor-utils-jvm"),
        artifact("org.jetbrains.kotlinx:kotlinx-coroutines-core-jvm"),
     ],
    main_class = "com.example.ServerKt"
)
