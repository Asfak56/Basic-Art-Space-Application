package com.example.artspace

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ArtSpace(viewModel: ArtViewModel) {
    val currentArtList by viewModel.currentArt.collectAsState()

    Scaffold(
        bottomBar = {
            BottomAppBar() {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 18.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Button(
                        onClick = { viewModel.onPreviousClicked() },
                        modifier = Modifier
                            .width(150.dp)
                    ) {
                        Text(
                            text = "Previous"
                        )
                    }
                    Button(
                        onClick = { viewModel.onNextClicked() },
                        modifier = Modifier
                            .width(150.dp)
                    ) {
                        Text(
                            text = "Next"
                        )
                    }
                }
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Surface(
                modifier = Modifier
                    .height(400.dp)
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                tonalElevation = 8.dp,
                shadowElevation = 8.dp,
                color = Color.White
            ) {
                Image(
                    painter = painterResource(id = currentArtList.img),
                    contentDescription = "Art Flower",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .padding(horizontal = 18.dp, vertical = 22.dp)
                )
            }

            Spacer(modifier = Modifier.height(62.dp))

            Surface(
                modifier = Modifier
                    .height(120.dp)
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                color = Color(0xFFD3D9F5),
                tonalElevation = 8.dp
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ) {
                    Text(
                        text = stringResource(id = currentArtList.title),
                        fontSize = 24.sp,
                        textAlign = TextAlign.Start,
                    )
                    Spacer(modifier = Modifier.padding(2.dp))
                    Row() {
                        Text(
                            text = stringResource(id = currentArtList.author),
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                        )
                        Spacer(modifier = Modifier.width(1.dp))
                        Text(
                            text = stringResource(id = currentArtList.date),
                            fontSize = 18.sp
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArtSpacePreview() {
//    ArtSpace()
}
















