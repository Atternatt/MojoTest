private const val composeVersion = "1.1.1"
private const val composeNavVersion = "2.4.0-alpha10"
private const val ktxVersion = "1.8.0"
private const val lifeCycleVersion = "2.4.1"
private const val activityComposeVersion = "1.4.0"

val androidXDebugBucket = DebugImplementationBucket(
    "androidx.compose.ui:ui-tooling" version composeVersion,
    "androidx.compose.ui:ui-test-manifest" version composeVersion
)

val composeMainBucket = ImplementationBucket(
    "androidx.compose.material:material" version composeVersion
)

val androidXBucket = ImplementationBucket(
    "androidx.core:core-ktx" version ktxVersion,
    "androidx.compose.ui:ui" version composeVersion,
    "androidx.compose.ui:ui-tooling-preview" version composeVersion,
    "androidx.compose.ui:ui-tooling" version composeVersion,
    "androidx.lifecycle:lifecycle-runtime-ktx" version lifeCycleVersion,
    "androidx.lifecycle:lifecycle-viewmodel-ktx" version lifeCycleVersion,
    "androidx.lifecycle:lifecycle-viewmodel-savedstate" version lifeCycleVersion,
    "androidx.lifecycle:lifecycle-viewmodel-compose" version lifeCycleVersion,
    "androidx.activity:activity-compose" version activityComposeVersion,
    "androidx.navigation:navigation-compose" version composeNavVersion
)