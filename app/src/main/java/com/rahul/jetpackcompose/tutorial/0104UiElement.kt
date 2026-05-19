package com.rahul.jetpackcompose.tutorial

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Greeting0104(
    modifier: Modifier = Modifier,
    name : String,
) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Column(
            modifier = modifier.height(100.dp).fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                modifier = modifier,
                text = "Hello $name!",
                style = MaterialTheme.typography.headlineLarge
            )
            Text("Having fun with compose!")
        }


        Row (
            modifier = modifier.height(100.dp).fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                modifier = modifier,
                text = "Hello $name!",
                style = MaterialTheme.typography.headlineLarge
            )
            Text("Having fun with compose row!")
        }

        Box (
            modifier = modifier.height(300.dp).fillMaxWidth(),
            contentAlignment = Alignment.TopEnd
        ) {
            Text(
                modifier = modifier,
                text = "Hello $name!",
                style = MaterialTheme.typography.headlineLarge
            )
            Text("Having fun with compose row!")
        }
    }

}

@Preview(showBackground = true)
@Composable
fun Greeting0104Preview() {
    Greeting0104(name = "world")
}

