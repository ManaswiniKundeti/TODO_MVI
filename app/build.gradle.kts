plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.dagger.hilt.android)
    id("kotlin-kapt")
    id("kotlin-parcelize")
}


android {
    namespace = "com.example.todo_mvi"
    compileSdk = 34


    defaultConfig {
        applicationId = "com.example.todo_mvi"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"


        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
        // Required for Hilt
        javaCompileOptions {
            annotationProcessorOptions {
                arguments["dagger.hilt.android.internal.disableAndroidSuperclassValidation"] = "true"
            }
        }
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
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1" // pawpics has 1.4.7
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
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


    // newly added dependencies
    // Retrofit for networking
    implementation(libs.retrofit)
    implementation(libs.retrofit.converter.gson)


    // Room for local database
    implementation(libs.room.runtime)
    kapt(libs.room.compiler)
    implementation(libs.room.ktx)


    // Coil for image loading in Compose
    implementation(libs.coil.compose)


    // compose runtime for viewmodel observe as state
    implementation(libs.compose.runtime.livedata)


    // Coroutines and Flows
    implementation(libs.coroutines.core)
    implementation(libs.coroutines.android)


    // Lifecycle and ViewModel
    implementation(libs.lifecycle.viewmodel.ktx)
    implementation(libs.lifecycle.livedata.ktx)


    // RecyclerView
    implementation(libs.recyclerview)


    // Hilt for Dependency Injection
    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)


    // Hilt for ViewModels in Compose
    implementation(libs.hilt.navigation.compose)


    // Hilt for testing
    androidTestImplementation(libs.hilt.android.testing)
    kaptAndroidTest(libs.hilt.compiler)


    // for unit testing
    testImplementation("org.mockito:mockito-core:3.11.2")
    testImplementation("org.mockito.kotlin:mockito-kotlin:5.4.0")
    androidTestImplementation("org.mockito.kotlin:mockito-kotlin:5.4.0")


    // For Coroutines Testing
    testImplementation(libs.kotlin.coroutines.test)
    testImplementation (libs.core.testing)
    // For Android Logging (Optional, mock log)
    testImplementation("androidx.test:core:1.4.0")
}


kapt {
    correctErrorTypes = true
}



