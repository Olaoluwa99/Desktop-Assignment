package org.assignment.project

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun BaseSection(
    modifier: Modifier,
    onMethodSelected: (Int) -> Unit = {}
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surfaceContainerHigh)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text("Non-Linear equation")
        Text("Select a Method")

        Button(
            onClick = { onMethodSelected(0) },
            contentPadding = PaddingValues(16.dp)
        ){
            Text("Fixed Point Iteration Method")
        }
        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = { onMethodSelected(1) },
            contentPadding = PaddingValues(16.dp)
        ){
            Text("Bisection Method")
        }
        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = { onMethodSelected(2) },
            contentPadding = PaddingValues(16.dp)
        ){
            Text("Newton Method")
        }
        Spacer(modifier = Modifier.height(60.dp))
    }
}