load("//:kotlin.bzl", "kt_jvm_binary", "kt_jvm_test")
load("@rules_jvm_external//:defs.bzl", "artifact")

java_library(
    name = "greeter",
    srcs = ["Greeting.java"],
)

kt_jvm_binary(
    name = "example",
    srcs = ["Example.kt"],
    main_class = "com.example.ExampleKt",
    deps = [
        ":greeter",
    ],
)

kt_jvm_test(
    name = "example_test",
    srcs = [
        "ExampleTest.kt",
    ],
    test_class = "com.example.ExampleTest",
    deps = [
        artifact("junit:junit"),
        ":greeter",
    ],
)

kt_jvm_binary(
    name = "server",
    srcs = ["Server.kt"],
    main_class = "com.example.ServerKt",
    deps = [
        "//third_party:ktor",
    ],
)
