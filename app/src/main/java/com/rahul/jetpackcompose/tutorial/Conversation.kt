package com.rahul.jetpackcompose.tutorial

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.rahul.jetpackcompose.ui.theme.JetpackComposeTheme

@Composable
fun  Conversation(messages:List<Message>) {
    LazyColumn {
        items(messages) {message ->
            MessageCard(message)
        }
    }

}

@Preview
@Composable
fun PreviewConversation() {
    JetpackComposeTheme {
        Conversation(SampleData.conversationSample)
    }
}