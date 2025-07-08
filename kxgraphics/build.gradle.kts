import top.laoshuzi.dependencies.deps.*
import top.laoshuzi.dependencies.publish.MavenPublish.mavenAndroidPublication
import top.laoshuzi.dependencies.publish.MavenPublish.mavenRepository

plugins {
    id("com.android.library")
    kotlin("android")
    `maven-publish`
}

group = "top.laoshuzi.android"
version = "0.1.0"

val ziweiRepositoryDomainName: String by project
val ziweiRepositoryUsername: String by project
val ziweiRepositoryPassword: String by project

val min_sdk_version: String by project
val target_sdk_version: String by project
val test_instrumentation_runner: String by project
val consumer_pro_file: String by project
val proguard_pro_file: String by project

android {
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_18
        targetCompatibility = JavaVersion.VERSION_18
    }
    compileSdk = target_sdk_version.toInt()
    defaultConfig {
        minSdk = min_sdk_version.toInt()
        testInstrumentationRunner = test_instrumentation_runner
        consumerProguardFiles(consumer_pro_file)
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(proguard_pro_file)
        }
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    implementation(deps(Kotlin.stdlib_jdk8))

    implementation(deps(Utilcode.utilcodex))
}

afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("mavenAndroid") {
                mavenAndroidPublication(project)
            }
        }
        repositories {
            maven {
                mavenRepository(
                    project,
                    ziweiRepositoryDomainName,
                    ziweiRepositoryUsername,
                    ziweiRepositoryPassword
                )
                isAllowInsecureProtocol = true
            }
        }
    }
}
