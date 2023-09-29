package ir.net_box.persiandatepickercomposem3.util

sealed class DatePickerType{
    object Year: DatePickerType()
    object Month: DatePickerType()
    object Day: DatePickerType()
}