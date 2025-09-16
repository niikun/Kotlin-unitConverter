package io.mastercoding.unitconverter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import io.mastercoding.unitconverter.ui.theme.UnitConverterTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material3.OutlinedTextField
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Button
import androidx.compose.ui.platform.LocalContext
import android.widget.Toast

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UnitConverterTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    UnitConverter(innerPadding)
                }
            }
        }
    }
}

@Composable
fun UnitConverter(padding: PaddingValues = PaddingValues(0.dp)){
    Column(modifier = Modifier.padding(padding)) {
        // すべてのUIが下に積まれていく
        Text("Unit Converter")
        OutlinedTextField(value = "", onValueChange = {
            // OutlinedTextFiledの値が変わったときに何をするか？
        })
        Row {
            val context = LocalContext.current
            //すべてのUIが横に並ぶ
            // Toast は 「どのアプリに出すメッセージか」 を区別するために Context が必須。
            //Compose の中では LocalContext.current を読むのが一番簡単で安全な方法です

            Button(onClick ={ Toast
                .makeText(context,
                    "Thanks for clicking",
                    Toast.LENGTH_LONG).show() })
            {
                Text("Click me!")
            }
        }
        Text("Result:")
    }
}

@Preview(showBackground = true)
@Composable
fun UnitConverterPreview(){
    UnitConverterTheme {
        UnitConverter() // 引数なしで安全に呼べる
    }
}


