plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.engineerfred.kotlin.rickymortyfinale"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.engineerfred.kotlin.rickymortyfinale"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }

        resources.excludes.add("META-INF/versions/9/previous-compilation-data.bin")
    }
}

dependencies {

    implementation(project(":feature:characters:ui"))
    implementation(project(":feature:characters:data"))
    implementation(project(":feature:characters:domain"))
    implementation(project(":feature:character_details:ui"))
    implementation(project(":feature:search:ui"))
//    implementation(project(":feature:character_details:data"))
//    implementation(project(":feature:character_details:domain"))
    implementation(project(":core:common"))
    implementation(project(":core:feature_api"))
    implementation(project(":core:theme"))

    implementation(Deps.coreKtx)
    implementation(Deps.lifecycleRunTimeKtx)
    implementation(Deps.splashScreen)
    compose()
    testImplementation(Deps.jUnit)
    androidTestImplementation(Deps.textExtJUnit)
    androidTestImplementation(Deps.espressoCore)
    androidTestImplementation(platform(Deps.composeBom))
    androidTestImplementation(Deps.composeJUnit4)
    debugImplementation(Deps.composeUiTooling)
    debugImplementation(Deps.composeUiTestManifest)
    paging()
    hilt()
    implementation(Deps.coil)
}