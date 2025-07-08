import top.laoshuzi.dependencies.deps.*
import java.util.*
import java.io.FileInputStream

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
}

val application_id: String by project
val version_code: String by project
val version_name: String by project
val min_sdk_version: String by project
val target_sdk_version: String by project
val test_instrumentation_runner: String by project
val consumer_pro_file: String by project
val proguard_pro_file: String by project


val keystoreProperties = Properties().apply {
    load(FileInputStream(rootProject.file("keystore.properties")))
}

android {
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_18
        targetCompatibility = JavaVersion.VERSION_18
    }
    compileSdk = target_sdk_version.toInt()
    defaultConfig {
        applicationId = application_id
        versionCode = version_code.toInt()
        versionName = version_name
        minSdk = min_sdk_version.toInt()
        targetSdk = target_sdk_version.toInt()
        testInstrumentationRunner = test_instrumentation_runner
        multiDexEnabled = true
    }
    lint {
        abortOnError = false
    }
    signingConfigs {
        create("release") {
            storeFile = file(keystoreProperties["signStoreFile"] as String)
            storePassword = keystoreProperties["signStorePassword"] as String
            keyAlias = keystoreProperties["signKeyAlias"] as String
            keyPassword = keystoreProperties["signKeyPassword"] as String
        }
    }
    buildTypes {
        getByName("release") {
            isDebuggable = false
            isMinifyEnabled = false
            signingConfig = signingConfigs.getByName("release")
            proguardFiles(proguard_pro_file)
        }
        getByName("debug") {
            isDebuggable = true
            signingConfig = signingConfigs.getByName("release")
            proguardFiles(proguard_pro_file)
        }
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.aar"))))

    implementation(project(":kxgraphics"))

    //kotlin
    implementation(deps(Kotlin.stdlib_jdk8))
//    implementation(deps(Kotlinx.kotlinx_coroutines_android))

    //structure
    implementation("top.laoshuzi.structure:core:0.1.1")
    implementation("top.laoshuzi.structure:qncx-structure:0.1.2")

    //test
//    testImplementation(deps(Junit.junit))
//    androidTestImplementation(deps(AndroidX.test_runner))
//    androidTestImplementation(deps(AndroidX.test_espresso))

    //koin
    implementation(deps(Koin.android))

    //component
    implementation(deps(Android.android_material))
    implementation(deps(AndroidX.multidex))
    implementation(deps(AndroidX.legacy_support_v4))
    implementation(deps(AndroidX.activity))
    implementation(deps(AndroidX.fragment))
    implementation(deps(AndroidX.appcompat))
    implementation(deps(AndroidX.recyclerview))
    implementation(deps(AndroidX.cardview))
    implementation(deps(AndroidX.constraintlayout))
    implementation(deps(AndroidX.viewpager2))

    //lifecycle
//    implementation(deps(AndroidX.lifecycle_viewmodel_ktx))
//    implementation(deps(AndroidX.lifecycle_livedata_ktx))

    //room
//    implementation(deps(AndroidX.room_runtime))
//    implementation(deps(AndroidX.room_ktx))
//    kapt(deps(AndroidX.room_compiler))

    //glide
//    implementation(deps(AndroidEx.glide))
//    kapt(deps(AndroidEx.glide_compiler))

    //tools
    implementation(deps(Utilcode.utilcodex))

}
