plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    id("kotlin-kapt")
    alias(libs.plugins.dagger.hilt)
    alias(libs.plugins.gms.google.services)
    alias(libs.plugins.kotlinx.serialization)
    id("kotlin-parcelize")
//    id("kotlin-parcelize")
}

android {
    namespace = "com.techtribeservices.helathline"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.techtribeservices.helathline"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    // dagger and hilt
    implementation(libs.hilt.android)
    kapt(libs.hilt.android.compiler)
    implementation(libs.androidx.hilt.navigation.compose)

    // Import the Firebase BoM
    implementation(platform(libs.firebase.bom))
    // TODO: Add the dependencies for Firebase products you want to use
    // When using the BoM, don't specify versions in Firebase dependencies
    implementation(libs.firebase.analytics)
    implementation(libs.firebase.firestore)

    // Gson
    implementation(libs.gson)

    // coil
    implementation(libs.coil.compose)

    // constraint layout
    implementation(libs.androidx.constraintlayout.compose)

    // okHttp
    implementation(libs.coil.network.okhttp)

    // adaptive layout
    implementation(libs.androidx.material3.adaptive.navigation.suite)

    // navigation
    implementation(libs.androidx.navigation.compose)

    // seriablization
    implementation(libs.kotlinx.serialization.json)

}

// Allow references to generated code
kapt {
    correctErrorTypes = true
}