package com.example.lr2

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.lr2.presentation.AppViewModel
import org.koin.compose.getKoin
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.rememberScrollState

@Composable
fun App() {

    val vm: AppViewModel = getKoin().get()
    val state by vm.state.collectAsState()
    val scrollState = rememberScrollState()

    MaterialTheme {
        Column(Modifier.padding(16.dp)) {
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                Button(onClick = { vm.getPosts() }) { Text("GET") }
                Button(onClick = { vm.addPost() }) { Text("POST") }
                Button(onClick = { vm.updatePost() }) { Text("PUT") }
                Button(onClick = { vm.deletePost() }) { Text("DELETE") }
            }

            Spacer(modifier = Modifier.height(16.dp))

            if (state.isLoading) CircularProgressIndicator()

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .verticalScroll(scrollState)
            ) {
                Text(state.result)
            }

            Text(state.error, color = MaterialTheme.colorScheme.error)
        }
    }
}