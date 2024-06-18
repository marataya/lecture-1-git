package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainView(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Preview
@Composable
private fun MainView(modifier:Modifier = Modifier) {
    Column() {
        Text(text = "Hello")
        Text(text = "World")
        Icon(imageVector = Icons.Default.Favorite, contentDescription = null)
        TileWithButtons(
            button1Text = "Button 1",
            button2Text = "Button 2",
            button3Text = "Button 3",
            onButton1Click = { /*TODO*/ },
            onButton2Click = { /*TODO*/ }) {
            
        }
    }
}

@Composable
fun TileWithButtons(
    button1Text: String,
    button2Text: String,
    button3Text: String,
    onButton1Click: () -> Unit,
    onButton2Click: () -> Unit,
    onButton3Click: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Button(onClick = onButton1Click) {
                Text(button1Text)
            }
            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = onButton2Click) {
                Text(button2Text)
            }
            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = onButton3Click) {
                Text(button3Text)
            }
        }
    }
}