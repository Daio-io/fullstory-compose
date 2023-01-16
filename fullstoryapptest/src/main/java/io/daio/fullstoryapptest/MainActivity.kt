package io.daio.fullstoryapptest

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.AbstractComposeView

class MainActivity : AppCompatActivity() {

    @OptIn(ExperimentalMaterialApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val content = TestScreenComposeView(this) {
            Column(Modifier.fillMaxSize()) {

                val sheetState =
                    rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Expanded)

                Surface {
                    ModalBottomSheetLayout(
                        sheetState = sheetState,
                        sheetContent = {
                            Text(text = "Sheet shown", color = Color.White)
                        },
                        sheetBackgroundColor = Color.Black,
                        scrimColor = Color.Black.copy(.8f)
                    ) {
                        Column {
                            repeat(10) {
                                Text("Text $it", color = Color.White)
                            }
                        }
                    }
                }
            }
        }

        setContentView(content)
    }
}

private class TestScreenComposeView(
    context: Context,
    private val content: ComposableContent
) : AbstractComposeView(context, null, 0) {

    @Composable
    override fun Content() {
        content()
    }
}

typealias ComposableContent = @Composable
    () -> Unit
