package ir.net_box.jalalidatepickercomposem3

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import ir.net_box.jalalidatepickercomposem3.ui.theme.JalaliDatePickerComposeM3Theme
import ir.net_box.persiandatepickercomposem3.JalaliDatePickerDialog

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JalaliDatePickerComposeM3Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val showDatePicker = rememberSaveable { mutableStateOf(false) }

                    if (showDatePicker.value) {
                        JalaliDatePickerDialog(
                            openDialog = showDatePicker,
                            onSelectDay = {
                                Log.d(
                                    "JalaliDatePicker",
                                    "onSelect: ${it.day} ${it.monthString} ${it.year}"
                                )
                            },
                            onConfirm = {
                                Log.d(
                                    "JalaliDatePicker",
                                    "onConfirm: ${it.day} ${it.monthString} ${it.year}"
                                )
                            },
                            backgroundColor = MaterialTheme.colorScheme.surfaceVariant,
                            fontFamily = FontFamily.Default,
                            yearTextColor = MaterialTheme.colorScheme.primary,
                            selectedIconColor = MaterialTheme.colorScheme.primary,
                            textColorHighlight = MaterialTheme.colorScheme.tertiary
                        )
                    }

                    Box {
                        Button(
                            modifier = Modifier.align(Alignment.Center),
                            onClick = { showDatePicker.value = true }) {
                            Text(text = "Show date picker")
                        }
                    }
                }
            }
        }
    }
}
