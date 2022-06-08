plugins {
    id("com.android.application")
    id("kotlin-android")
}

android {
    compileSdk = AndroidSdk.compile
    namespace = AppDefaultConfig.applicationId
    defaultConfig {
        applicationId = AppDefaultConfig.applicationId
        minSdk = AndroidSdk.min
        targetSdk = AndroidSdk.target
        versionCode = AppDefaultConfig.appVersionCode
        versionName = AppDefaultConfig.versionName
        testInstrumentationRunner = AppDefaultConfig.instrumentationRunner
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
        getByName("debug") {
            isMinifyEnabled = false
            isDebuggable = true
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
        freeCompilerArgs = freeCompilerArgs + "-Xcontext-receivers"
    }

    buildFeatures {
        compose = true
    }


    composeOptions {
        kotlinCompilerExtensionVersion = "1.1.1"
    }

    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

//inject all the dependencies
buckets(androidXBucket, androidXDebugBucket, composeMainBucket)

dependencies {
    implementation(project(":engine"))
}

