package org.assignment.project.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import org.assignment.project.model.IterationResult
import org.assignment.project.model.bisectionMethod
import org.assignment.project.ui.utils.GenericArea

@Composable
fun BisectionMethodUI(
    modifier: Modifier
) {
    var results by remember { mutableStateOf<List<IterationResult>>(emptyList()) }
    val f: (Double) -> Double = { it * it * it - it - 2 }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "Bisection Method",
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.onBackground,
            fontWeight = FontWeight.Bold
        )

        GenericArea(
            type = 1,
            "Bisection Method",
            onCalculate = { initialGuess, leftEndpoint, rightEndpoint, maxIterations, tolerance ->
                results = bisectionMethod(
                    f = f,
                    a0 = leftEndpoint.toDoubleOrNull() ?: 1.0,
                    b0 = rightEndpoint.toDoubleOrNull() ?: 2.0,
                    tol = tolerance.toDoubleOrNull() ?: 1e-6,
                    maxIter = maxIterations.toIntOrNull() ?: 50
                )
            }
        )

        if (results.isNotEmpty()) {
            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(24.dp))
                    .background(MaterialTheme.colorScheme.surfaceContainerHigh)
                    .padding(top = 24.dp, bottom = 0.dp, start = 24.dp, end = 24.dp)
            ){
                Text("Results:", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
                LazyColumn {
                    items(results.size) { r ->
                        Text("Iter ${results[r].iteration}: x = ${results[r].x}, error = ${results[r].error}")
                    }

                    item{
                        Spacer(modifier = Modifier.height(24.dp))
                    }
                }
            }
        }
    }
}