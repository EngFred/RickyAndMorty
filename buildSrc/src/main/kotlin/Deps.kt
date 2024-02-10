import org.gradle.api.artifacts.dsl.DependencyHandler

object Deps {

    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    const val lifecycleRunTimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycleRunTimeKtx}"
    const val activityCompose = "androidx.activity:activity-compose:${Versions.activityCompose}"
    const val composeBom = "androidx.compose:compose-bom:${Versions.composeBom}"
    const val composeUi = "androidx.compose.ui:ui"
    const val composeUiTooling = "androidx.compose.ui:ui-tooling"
    const val composeUiTestManifest = "androidx.compose.ui:ui-test-manifest"
    const val composeGraphics = "androidx.compose.ui:ui-graphics"
    const val composePreview = "androidx.compose.ui:ui-tooling-preview"
    const val composeMaterial3 = "androidx.compose.material3:material3"
    const val composeJUnit4 = "androidx.compose.ui:ui-test-junit4"
    const val jUnit = "junit:junit:${Versions.jUnit}"
    const val textExtJUnit = "androidx.test.ext:junit:${Versions.textExtJUnit}"
    const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espressoCore}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val ktorCore = "io.ktor:ktor-client-core:${Versions.ktor}"
    const val ktorOkHttp = "io.ktor:ktor-client-okhttp:${Versions.ktor}"
    const val ktorContentNegotiation = "io.ktor:ktor-client-content-negotiation:${Versions.ktor}"
    const val ktorKotlinSerialization = "io.ktor:ktor-serialization-kotlinx-json:${Versions.ktor}"
    const val ktorLogging = "io.ktor:ktor-client-logging:${Versions.ktor}"
    const val coil = "io.coil-kt:coil-compose:${Versions.coil}"
    const val splashScreen = "androidx.core:core-splashscreen:${Versions.splashScreen}"
    const val lifeCycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifeCycleViewModel}"
    const val composeNavigation = "androidx.navigation:navigation-compose:${Versions.composeNavigation}"
    const val hiltAndroid = "com.google.dagger:hilt-android:${Versions.hiltAndroid}"
    const val hiltNavigationCompose = "androidx.hilt:hilt-navigation-compose:${Versions.hiltNavigationCompose}"
    const val hiltCompiler = "com.google.dagger:hilt-android-compiler:${Versions.hiltAndroid}"
    const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    const val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    const val materialIconsExtended = "androidx.compose.material:material-icons-extended"
    const val kotlinXSerialization = "org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.kotlinXSerialization}"
    const val pagingRuntimeKtx = "androidx.paging:paging-runtime-ktx:${Versions.pagingRuntimeKtx}"
    const val pagingCompose = "androidx.paging:paging-compose:${Versions.pagingCompose}"
}


fun DependencyHandler.hilt() {
    implementation(Deps.hiltAndroid)
    implementation(Deps.hiltNavigationCompose)
    kapt(Deps.hiltCompiler)
}

fun DependencyHandler.coroutines() {
    implementation(Deps.coroutinesAndroid)
    implementation(Deps.coroutinesCore)
}

fun DependencyHandler.paging() {
    implementation(Deps.pagingRuntimeKtx)
    implementation(Deps.pagingCompose)
}
fun DependencyHandler.compose() {
    implementation(Deps.activityCompose)
    implementation(platform(Deps.composeBom))
    implementation(Deps.composeUi)
    implementation(Deps.composeGraphics)
    implementation(Deps.composePreview)
    implementation(Deps.composeMaterial3)
}

fun DependencyHandler.ktor() {
    implementation(Deps.ktorCore)
    implementation(Deps.ktorOkHttp)
    implementation(Deps.ktorContentNegotiation)
    implementation(Deps.ktorLogging)
    implementation(Deps.ktorKotlinSerialization)
}