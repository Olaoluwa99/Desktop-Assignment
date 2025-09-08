package org.assignment.project.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun FixedPointIterationUI(
    modifier: Modifier
) {
    Column(
        //modifier = Modifier.background(MaterialTheme.colorScheme.surfaceContainerHigh),
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text("Fixed Point Iteration")
    }
}