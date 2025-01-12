package com.androidstartercode2024.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.androidstartercode2024.R

@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun ImageTopAppBar(
    imagePainter: Painter,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(200.dp) // Adjust height as needed
            //.background(Color.Transparent) // Optional: Make the background transparent
    ) {
        Image(
            painter = imagePainter,
            contentDescription = "Top App Bar Image",
            modifier = Modifier
                .fillMaxSize(), // Fill the entire Box
            contentScale = ContentScale.FillBounds // Fill the bounds of the Image
        )
    }
}

@Composable
@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
fun TopAppBarPreview() {
    val imagePainter = painterResource(id = R.drawable.mathquest_logo) // Replace with your actual image resource
    ImageTopAppBar(imagePainter = imagePainter)
}