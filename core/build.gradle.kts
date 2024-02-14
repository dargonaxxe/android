plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "core"
    compileSdk = Build.compileSdkVersion

    defaultConfig {
        minSdk = Build.minSdkVersion
        consumerProguardFiles("consumer-rules.pro")
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(Libs.KotlinX.coroutines)
    implementation(Libs.AndroidX.lifecycle)
    implementation(Libs.AndroidX.security)

    implementation(Libs.Squareup.okhttp)
    implementation(Libs.Squareup.sse)
    implementation(Libs.zxing)

    implementation(Libs.ML.barcode)
    implementation(Libs.AndroidX.Camera.base)
    implementation(Libs.ton)
}