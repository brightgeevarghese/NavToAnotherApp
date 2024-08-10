package edu.miu.navtoanotherapp.ui

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        val context = LocalContext.current
        Button(
            onClick = {
                //Create an intent for sending data
                val intent = Intent(Intent.ACTION_SEND).apply {
                    type = "text/plain"
                    putExtra(Intent.EXTRA_EMAIL, arrayOf("bvarghese@miu.edu"))
                    putExtra(Intent.EXTRA_SUBJECT, "Hello")
                    putExtra(Intent.EXTRA_TEXT, "Hello World!")
                }

            // This line starts an activity with an intent that the user can choose how to handle.
            // The intent is wrapped inside an Intent.createChooser call, which creates a chooser dialog
            // that allows the user to select an app to perform the action described by the intent.
            context.startActivity(
                // The Intent.createChooser method is called with the intent object you've created.
                // The second parameter is the title of the chooser dialog. By passing 'null',
                // you're indicating that you don't want to set any title for the chooser dialog.
                Intent.createChooser(intent, null)
            )

            },
            modifier = modifier
        ) {
            Text(text = "Send")
        }
    }


}