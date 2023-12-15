plugins {
    `java-library`
}

dependencies {
    compileOnly(libs.miniplaceholders)
    compileOnlyApi(libs.chunky)
    compileOnly(libs.adventure.api)
    compileOnly(libs.adventure.minimessage)
}