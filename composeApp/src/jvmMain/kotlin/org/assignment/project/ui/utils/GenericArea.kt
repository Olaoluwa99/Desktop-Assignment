package org.assignment.project.ui.utils

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun GenericArea(
    type: Int,
    methodText: String,
    onCalculate: (initialGuess: String, leftEndpoint: String, rightEndpoint: String, maxIterations: String, tolerance: String) -> Unit
) {
    //Fixed point
    var initialGuess by remember { mutableStateOf("") }

    //Bisection method
    var leftEndpoint by remember { mutableStateOf("") }
    var rightEndpoint by remember { mutableStateOf("") }

    var maxIterations by remember { mutableStateOf("") }
    var tolerance by remember { mutableStateOf("") }
    var defaultWidth by remember { mutableIntStateOf(300) }

    Column {
        Spacer(modifier = Modifier.height(12.dp))
        Divider()
        Spacer(modifier = Modifier.height(12.dp))

        Text("To test the $methodText, enter the following:")
        Spacer(modifier = Modifier.height(12.dp))

        FlowRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            if (type == 0  || type == 2){
                OutlinedTextField(
                    value = initialGuess,
                    onValueChange = { initialGuess = it },
                    label = { Text("Input your guess") },
                    modifier = Modifier.width(defaultWidth.dp)
                )
            }

            if (type == 1){
                OutlinedTextField(
                    value = leftEndpoint,
                    onValueChange = { leftEndpoint = it },
                    label = { Text("Left endpoint a") },
                    modifier = Modifier.width(defaultWidth.dp)
                )
            }

            if (type == 1){
                OutlinedTextField(
                    value = rightEndpoint,
                    onValueChange = { rightEndpoint = it },
                    label = { Text("Right endpoint b") },
                    modifier = Modifier.width(defaultWidth.dp)
                )
            }

            OutlinedTextField(
                value = maxIterations,
                onValueChange = { maxIterations = it },
                label = { Text("Maximum iterations") },
                modifier = Modifier.width(defaultWidth.dp)
            )

            OutlinedTextField(
                value = tolerance,
                onValueChange = { tolerance = it },
                label = { Text("Tolerance") },
                modifier = Modifier.width(defaultWidth.dp)
            )

            Button(
                onClick = { onCalculate(initialGuess, leftEndpoint, rightEndpoint, maxIterations, tolerance) },
                modifier = Modifier.width(defaultWidth.dp).padding(top = 8.dp),
                contentPadding = PaddingValues(16.dp),
                shape = RoundedCornerShape(16.dp)
            ) {
                Text("Calculate")
            }
        }

        Spacer(modifier = Modifier.height(24.dp))
        Divider()
        Spacer(modifier = Modifier.height(24.dp))
    }
}