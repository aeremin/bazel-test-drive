load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")

###############################################################################
# rules_kotlin dependencies
# See instruction at https://github.com/bazelbuild/rules_kotlin#quick-guide

# Use local check-out of repo rules (or a commit-archive from github via http_archive or git_repository)
http_archive(
    name = "io_bazel_rules_kotlin_master",
    sha256 = "6ef7ed634bff1d4b0eb3cd7d96c7b0861429d2cc33fad4d1b078cab2e0d7b516",
    strip_prefix = "rules_kotlin-master",
    urls = ["https://github.com/aeremin/rules_kotlin/archive/refs/heads/master.zip"],
)

load("@io_bazel_rules_kotlin_master//src/main/starlark/release_archive:repository.bzl", "archive_repository")

archive_repository(
    name = "io_bazel_rules_kotlin",
    source_repository_name = "io_bazel_rules_kotlin_master",
)

load("@io_bazel_rules_kotlin//kotlin:repositories.bzl", "kotlin_repositories")

kotlin_repositories()  # if you want the default. Otherwise see custom kotlinc distribution below

load("@io_bazel_rules_kotlin//kotlin:core.bzl", "kt_register_toolchains")

kt_register_toolchains()  # to use the default toolchain, otherwise see toolchains below

###############################################################################
# maven_install dependencies (to install external dependencies from maven repository)
# See instruction at https://github.com/bazelbuild/rules_jvm_external#usage
http_archive(
    name = "rules_jvm_external",
    sha256 = "cd1a77b7b02e8e008439ca76fd34f5b07aecb8c752961f9640dea15e9e5ba1ca",
    strip_prefix = "rules_jvm_external-4.2",
    url = "https://github.com/bazelbuild/rules_jvm_external/archive/4.2.zip",
)

load("@rules_jvm_external//:repositories.bzl", "rules_jvm_external_deps")

rules_jvm_external_deps()

load("@rules_jvm_external//:setup.bzl", "rules_jvm_external_setup")

rules_jvm_external_setup()

load("@rules_jvm_external//:defs.bzl", "maven_install")

maven_install(
    artifacts = [
        "org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.7.10",
        "org.jetbrains.kotlinx:kotlinx-coroutines-core-jvm:1.6.4",
        "io.ktor:ktor-server-core-jvm:2.0.3",
        "io.ktor:ktor-server-netty-jvm:2.0.3",
        "io.ktor:ktor-server-host-common-jvm:2.0.3",
        "io.ktor:ktor-http-jvm:2.0.3",
        "io.ktor:ktor-utils-jvm:2.0.3",
        "junit:junit:4.12",
        "io.kotest:kotest-assertions-core-jvm:5.3.2",
        "org.slf4j:slf4j-api:1.7.36",
        "org.slf4j:slf4j-simple:1.7.36",
    ],
    repositories = [
        "https://maven.google.com",
        "https://repo1.maven.org/maven2",
    ],
)

###############################################################################
# rules_docker dependencies
# See instruction at https://github.com/bazelbuild/rules_docker/blob/master/README.md#setup

http_archive(
    name = "io_bazel_rules_docker",
    sha256 = "b1e80761a8a8243d03ebca8845e9cc1ba6c82ce7c5179ce2b295cd36f7e394bf",
    urls = ["https://github.com/bazelbuild/rules_docker/releases/download/v0.25.0/rules_docker-v0.25.0.tar.gz"],
)

load(
    "@io_bazel_rules_docker//repositories:repositories.bzl",
    container_repositories = "repositories",
)

container_repositories()

load("@io_bazel_rules_docker//repositories:deps.bzl", container_deps = "deps")

container_deps()

load(
    "@io_bazel_rules_docker//java:image.bzl",
    java_image_repos = "repositories",
)

java_image_repos()

###############################################################################
# rules_nodejs dependencies
# See instruction at https://bazelbuild.github.io/rules_nodejs/install.html
http_archive(
    name = "build_bazel_rules_nodejs",
    sha256 = "f10a3a12894fc3c9bf578ee5a5691769f6805c4be84359681a785a0c12e8d2b6",
    urls = ["https://github.com/bazelbuild/rules_nodejs/releases/download/5.5.3/rules_nodejs-5.5.3.tar.gz"],
)

load("@build_bazel_rules_nodejs//:repositories.bzl", "build_bazel_rules_nodejs_dependencies")

build_bazel_rules_nodejs_dependencies()

# fetches nodejs, npm, and yarn
load("@build_bazel_rules_nodejs//:index.bzl", "node_repositories")

node_repositories()

load("@build_bazel_rules_nodejs//:index.bzl", "yarn_install")

yarn_install(
    name = "npm",
    package_json = "//:package.json",
    yarn_lock = "//:yarn.lock",
)
