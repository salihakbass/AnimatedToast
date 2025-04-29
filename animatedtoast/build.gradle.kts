plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    id("maven-publish")
}

android {
    namespace = "com.salihakbas.animatedtoast"
    compileSdk = 35

    defaultConfig {
        minSdk = 21
        targetSdk = 35

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
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
}

dependencies {
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.material3)
}

afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("release") {
                from(components["release"])

                groupId = "com.github.salihakbass"
                artifactId = "animatedtoast"
                version = "1.0.0"

                pom {
                    name.set("AnimatedToast")
                    description.set("A beautiful animated toast library for Jetpack Compose.")
                    url.set("https://github.com/salihakbass/AnimatedToast")

                    licenses {
                        license {
                            name.set("The MIT License")
                            url.set("https://opensource.org/licenses/MIT")
                        }
                    }
                    developers {
                        developer {
                            id.set("salihakbass")
                            name.set("Salih Akbaş")
                            email.set("salihhakbass@gmail.com")
                        }
                    }
                    scm {
                        connection.set("scm:git:github.com/salihakbass/AnimatedToast.git")
                        developerConnection.set("scm:git:ssh://github.com/salihakbass/AnimatedToast.git")
                        url.set("https://github.com/salihakbass/AnimatedToast")
                    }
                }
            }
        }
    }
}