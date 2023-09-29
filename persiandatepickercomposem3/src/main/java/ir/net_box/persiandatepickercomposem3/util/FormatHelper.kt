package ir.net_box.persiandatepickercomposem3.util

import androidx.core.text.isDigitsOnly

object FormatHelper {
    private val persianDigits = arrayOf("۰", "۱", "۲", "۳", "۴", "۵", "۶", "۷", "۸", "۹")
    fun toPersianDigit(value: String): String {
        if (value.isDigitsOnly().not() || value.isEmpty()) {
            return ""
        }
        var outPut = ""
        for (element in value) {
            when (element) {
                in '0'..'9' -> {
                    val number = element.toString().toInt()
                    outPut += persianDigits[number]
                }
                '٫' -> {
                    outPut += '،'
                }

                else -> {
                    outPut += element
                }
            }
        }
        return outPut
    }
}