load("//:kotlin.bzl", "kt_jvm_binary", "kt_jvm_test")

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