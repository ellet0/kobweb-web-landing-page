package net.freshplatform.landingpagedemo.utils.extensions

fun String.removeCharAtIndex(index: Int): String {
    val string = this
    if (index < 0 || index >= string.length) {
        return string
    }
    return string.substring(0, index) + string.substring(index + 1)
}