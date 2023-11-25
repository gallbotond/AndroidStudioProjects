package com.example.androidbasics2023

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.androidbasics2023.ui.theme.AndroidBasics2023Theme
import com.example.androidbasics2023.ui.theme.ImageViewModel

// we need context to enable classes to operate in the android environment
// such as read files etc
class MyClass(private val context: Context) {

}

// context in activity destroyed when activity is changed or updated or killed
class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<ImageViewModel>() // one way to preserve state
//    private val viewModel by viewModels<ContactsViewModel>() // one way to preserve state
//    private val viewModel by viewModels<MyViewModel>() // example for memory leak


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        viewModel.context = this // memory leak
        resources.getDrawable(R.drawable.ic_launcher_background, theme)
        setContent {
            AndroidBasics2023Theme {

//                val viewModel = viewModel<ContactsViewModel>(
//                    // how we pass down arguments to the view model
//                    factory = object : ViewModelProvider.Factory {
//                        override fun <T : ViewModel> create(modelClass: Class<T>): T {
//                            return ContactsViewModel(
//                                hello = "Hello"
//                            ) as T
//                        }
//                    }
//
//                ) // another way to preserve state
//                ViewModels(viewModel = viewModel)
                Button(onClick = {
                    Intent(applicationContext, SecondActivity::class.java).also {
                        startActivity(it)
                    }
//                    Intent(Intent.ACTION_MAIN).also {
//                        it.`package` = "com.google.android.youtube"
//                        try {
//                            startActivity(it)
//                        } catch(e: ActivityNotFoundException) {
//                            println("Activity not found")
//                            e.printStackTrace()
//                        }
//                    }
                    val intent = Intent(Intent.ACTION_SEND).apply {
                        type = "text/plain"
                        putExtra(Intent.EXTRA_EMAIL, arrayOf("text@test.com"))
                        putExtra(Intent.EXTRA_SUBJECT, "Subject")
                        putExtra(Intent.EXTRA_TEXT, "Text")
                    }
                    if (intent.resolveActivity(packageManager) != null) {
                        startActivity(intent)
                    }
                }) {
                    Text(text = "Go to second activity")
                }
                viewModel.uri?.let {
                    AsyncImage(model = viewModel.uri, contentDescription = "img")
                }
            }
        }
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        println("onNewIntent")
        val uri = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent?.getParcelableArrayExtra(Intent.EXTRA_STREAM, Uri::class.java)
        } else {
            intent?.getParcelableArrayExtra(Intent.EXTRA_STREAM)
        }
        viewModel.updateUri(uri?.get(0) as Uri)
    }

    override fun onStart() {
        super.onStart()
        println("onStart")
    }

    override fun onResume() {
        super.onResume()
        println("onResume")
    }

    override fun onPause() {
        super.onPause()
        println("onPause")
    }

    override fun onStop() {
        super.onStop()
        println("onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        println("onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        println("onRestart")
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AndroidBasics2023Theme {
        Greeting("Android")
    }
}

@Composable
fun ViewModels(
    viewModel: ContactsViewModel
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = viewModel.backgroundColor
    ) {

        Button(onClick = {
            viewModel.changeBackgroundColor()
        }) {
            Text(text = "Change Background Color")
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = "img"
            )
        }
    }
}