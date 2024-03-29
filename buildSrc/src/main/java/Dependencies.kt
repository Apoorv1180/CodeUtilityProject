object Version {
    const val core = "1.9.0"
    const val appcompat = "1.5.1"
    const val constraintLayout = "2.1.4"
    const val testRunner = "1.5.2"
    const val testImplJunit = "4.13.2"
    const val androidTestImplJunit = "1.1.3"
    const val androidTestEspresso = "3.4.0"
    const val retrofit = "2.9.0"
    const val gsonConvertor = "2.9.0"
    const val okHttp = "4.9.0"
    const val scalerConvertor = "2.1.0"
    const val kotlinCoroutines = "1.6.1"
    const val coroutineLifecycleScope = "2.5.1"
    const val dagger = "2.50"
    const val hiltComposeNavigation = "1.0.0"

    // compose
    const val composeUiVersion = "1.3.3"
    const val composeActivity = "1.6.1"
    const val composeMaterial = "1.3.1"
    const val composeMaterial3 = "1.1.2"
    const val composeNavigation = "2.6.0-alpha05"
    const val coilImageLoading = "2.2.2"
    const val composeRuntime = "1.6.0"

    // testImplementation versions
    const val kotlinxCoroutine = "1.6.4"
    const val turbine = "0.12.1"
    const val mockito = "3.9.0"
    const val mockitoKotlin = "2.0.0"
    const val mockitoInline = "2.25.0"

    // dagger hilt testing
    const val daggerHiltTestImpl = "2.50"
    const val daggerHiltAndroidTestImpl = "2.50"
}

object DependencyConstants {
    const val core = "androidx.core:core-ktx:${Version.core}"
    const val appCompat = "androidx.appcompat:appcompat:${Version.appcompat}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Version.constraintLayout}"

    // testing
    const val testRunner = "androidx.test:runner:${Version.testRunner}"

}

object AndroidX {
    const val androidXRuntime = "androidx.compose.runtime:runtime:${Version.composeRuntime}"
    const val androidXRuntimeLiveData =
        "androidx.compose.runtime:runtime-livedata:${Version.composeRuntime}"
    const val androidXRuntimeRxJava =
        "androidx.compose.runtime:runtime-rxjava2:${Version.composeRuntime}"
}

object TestImplementation {
    const val junit = "junit:junit:${Version.testImplJunit}"
    const val kotlinxCoroutine =
        "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Version.kotlinxCoroutine}"
    const val turbine = "app.cash.turbine:turbine:${Version.turbine}"
    const val mockito = "org.mockito:mockito-core:${Version.mockito}"
    const val mockitoKotlin = "com.nhaarman.mockitokotlin2:mockito-kotlin:${Version.mockitoKotlin}"
    const val mockitoInline = "org.mockito:mockito-inline:${Version.mockitoInline}"
}

object AndroidTestImplementation {
    const val junit = "androidx.test.ext:junit:${Version.androidTestImplJunit}"
    const val espresso = "androidx.test.espresso:espresso-core:${Version.androidTestEspresso}"

}

object Retrofit {
    const val retrofit = "com.squareup.retrofit2:retrofit:${Version.retrofit}"
    const val gsonConvertor = "com.squareup.retrofit2:converter-gson:${Version.gsonConvertor}"
    const val okHttp = "com.squareup.okhttp3:okhttp:${Version.okHttp}"
    const val scalersConvertors =
        "com.squareup.retrofit2:converter-scalars:${Version.scalerConvertor}"
}

object Coroutines {
    const val coroutineCore =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Version.kotlinCoroutines}"
    const val coroutineAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Version.kotlinCoroutines}"
}

object CoroutinesLifecycleScope {
    const val lifecycleViewModel =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Version.coroutineLifecycleScope}"
    const val lifeCycleRuntime =
        "androidx.lifecycle:lifecycle-runtime-ktx:${Version.coroutineLifecycleScope}"
}

object DaggerHilt {
    const val hilt = "com.google.dagger:hilt-android:${Version.dagger}"
    const val hiltAndroidCompiler = "com.google.dagger:hilt-android-compiler:${Version.dagger}"
    const val hiltCompiler = "com.google.dagger:hilt-compiler:${Version.dagger}"
    const val hiltComposeNavigation =
        "androidx.hilt:hilt-navigation-compose:${Version.hiltComposeNavigation}"
}

object DaggerHiltTestingTestImpl {
    // For Robolectric tests.
    const val daggerHiltTestImplRobolectric =
        "com.google.dagger:hilt-android-testing:${Version.daggerHiltTestImpl}"
    const val daggerHiltKaptTestRobolectric =
        "com.google.dagger:hilt-android-compiler:${Version.daggerHiltTestImpl}"

    // For instrumented tests.
    const val daggerHiltAndroidTestImpl =
        "com.google.dagger:hilt-android-testing:${Version.daggerHiltAndroidTestImpl}"
    const val daggerHiltAndroidTestKapt =
        "com.google.dagger:hilt-android-compiler:${Version.daggerHiltAndroidTestImpl}"
}

// compose

object JetpackCompose {
    const val composeActivity = "androidx.activity:activity-compose:${Version.composeActivity}"
    const val composeUi = "androidx.compose.ui:ui:${Version.composeUiVersion}"
    const val composeUiToolingPreview =
        "androidx.compose.ui:ui-tooling-preview:${Version.composeUiVersion}"
    const val androidMaterial3 = "androidx.compose.material3:material3:${Version.composeMaterial3}"
    const val navigation = "androidx.navigation:navigation-compose:${Version.composeNavigation}"
}

object ComposeAndroidTestImplementation {
    const val composeUiTest = "androidx.compose.ui:ui-test-junit4:${Version.composeMaterial}"
}

object ComposeDebugImplementation {
    const val toolingUi = "androidx.compose.ui:ui-tooling:${Version.composeUiVersion}"
    const val manifestTest = "androidx.compose.ui:ui-test-manifest:${Version.composeUiVersion}"
}