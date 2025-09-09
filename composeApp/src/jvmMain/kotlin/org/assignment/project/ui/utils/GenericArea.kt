package org.assignment.project.ui.utils

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun GenericArea(
    type: Int,
    methodText: String,
    defaultGuess: Double,
    defaultMaxIterations: Int,
    defaultTolerance: Double,
    defaultLeftEndpoint: Double,
    defaultRightEndpoint: Double,
    onCalculate: (String, String, String, String, String) -> Unit
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

        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(16.dp))
                .background(MaterialTheme.colorScheme.surfaceContainerHigh)
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ){
            when(type){
                0 -> {
                    Text(buildAnnotatedString {
                        append("g(x) = cos(x)")
                    },
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold)
                }
                1 -> {
                    Text(buildAnnotatedString {
                        append("f(x) = x")
                        withStyle(SpanStyle(baselineShift = BaselineShift.Superscript)) {
                            append("3")
                        }
                        append(" - x - 2")
                    },
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold
                    )
                }
                2 -> {
                    Row (
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Text(buildAnnotatedString {
                            append("f(x) = x")
                            withStyle(SpanStyle(baselineShift = BaselineShift.Superscript)) {
                                append("3")
                            }
                            append(" - x - 2")
                        }, style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)

                        Spacer(modifier = Modifier.width(16.dp))
                        Box(modifier = Modifier.width(1.dp).height(36.dp).background(MaterialTheme.colorScheme.primary))
                        Spacer(modifier = Modifier.width(16.dp))

                        Text(buildAnnotatedString {
                            append("f'(x) = 3x")
                            withStyle(SpanStyle(baselineShift = BaselineShift.Superscript)) {
                                append("2")
                            }
                            append(" - 1")
                        }, style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        Text("To solve the above equation using $methodText, enter the following or press calculate to use the default values to solve the equation:")
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
                    label = { Text("Input your guess (Default: $defaultGuess)") },
                    modifier = Modifier.width(defaultWidth.dp)
                )
            }

            if (type == 1){
                OutlinedTextField(
                    value = leftEndpoint,
                    onValueChange = { leftEndpoint = it },
                    label = { Text("Left endpoint a (Default: $defaultLeftEndpoint)") },
                    modifier = Modifier.width(defaultWidth.dp)
                )
            }

            if (type == 1){
                OutlinedTextField(
                    value = rightEndpoint,
                    onValueChange = { rightEndpoint = it },
                    label = { Text("Right endpoint b (Default: $defaultRightEndpoint)") },
                    modifier = Modifier.width(defaultWidth.dp)
                )
            }

            OutlinedTextField(
                value = maxIterations,
                onValueChange = { maxIterations = it },
                label = { Text("Maximum iterations (Default: $defaultMaxIterations)") },
                modifier = Modifier.width(defaultWidth.dp)
            )

            OutlinedTextField(
                value = tolerance,
                onValueChange = { tolerance = it },
                label = { Text("Tolerance (Default: $defaultTolerance)") },
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