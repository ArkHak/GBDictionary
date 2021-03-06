plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-android")
    id("kotlin-android-extensions")
    id("androidx.navigation.safeargs.kotlin")
    id("kotlin-kapt")
}

android {
    compileSdk = 31

    defaultConfig {
        applicationId = "ru.omysin.gbdictionary"
        minSdk = 21
        targetSdk = 31
        versionCode = 1
        versionName = "1.0"
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

    buildFeatures {
        viewBinding = true
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
    implementation(project(":utils"))
    implementation(project(":domain"))

    //AndroidX
    implementation("androidx.appcompat:appcompat:1.4.2")

    //Design
    implementation("com.google.android.material:material:1.6.1")

    //Kotlin
    implementation("androidx.core:core-ktx:1.8.0")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.6.21")

    //Retrofit 2
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.retrofit2:adapter-rxjava3:2.9.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.4.1")

    //Coil
    implementation("io.coil-kt:coil:0.11.0")

    //Navigation
    implementation("androidx.navigation:navigation-fragment-ktx:2.4.2")
    implementation("androidx.navigation:navigation-ui-ktx:2.4.2")
    implementation("androidx.navigation:navigation-dynamic-features-fragment:2.4.2")

    //Room
    implementation("androidx.room:room-runtime:2.4.2")
    kapt("androidx.room:room-compiler:2.4.2")
    implementation("androidx.room:room-ktx:2.4.2")

    //Koin
    implementation("io.insert-koin:koin-core:3.1.6")
    implementation("io.insert-koin:koin-android:3.1.6")
    implementation("io.insert-koin:koin-android-compat:3.1.6")

    //Coroutine
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.1")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.1")

    //Gson
    implementation("com.google.code.gson:gson:2.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    //SplashScreen
    implementation("androidx.core:core-splashscreen:1.0.0-rc01")
}