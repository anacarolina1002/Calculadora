plugins {
    id("com.android.application")
}

android {
    compileSdkVersion(34)
    buildToolsVersion("34.0.0")

    defaultConfig {
        applicationId = "com.example.calculadora"
        minSdkVersion(24)
        targetSdkVersion(34)
        versionCode = 1
        versionName = "1.0"
        namespace = "com.example.calculadora"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
    implementation(libs.exp4j)
}
