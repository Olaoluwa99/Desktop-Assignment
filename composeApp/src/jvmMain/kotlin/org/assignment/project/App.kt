package org.assignment.project

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import org.assignment.project.ui.BisectionMethodUI
import org.assignment.project.ui.FixedPointIterationUI
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.assignment.project.ui.NewtonMethodUI

import androidx.compose.animation.*
import androidx.compose.runtime.*

@Composable
@Preview
fun App() {
    MaterialTheme {
        var selectedContent by remember { mutableStateOf(0) }

        Row(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.primaryContainer)
                .safeContentPadding()
                .fillMaxSize(),
        ) {
            BaseSection(
                modifier = Modifier.weight(3f),
                onMethodSelected = { content ->
                    selectedContent = content
                }
            )

            AnimatedContent(
                targetState = selectedContent,
                transitionSpec = {
                    // Slide down when going forward, up when going back
                    if (targetState > initialState) {
                        slideInVertically { -it } + fadeIn() togetherWith
                                slideOutVertically { it } + fadeOut()
                    } else {
                        slideInVertically { it } + fadeIn() togetherWith
                                slideOutVertically { -it } + fadeOut()
                    }
                },
                modifier = Modifier.weight(5f),
                label = "ContentAnimation"
            ) { state ->
                when (state) {
                    0 -> FixedPointIterationUI(modifier = Modifier.fillMaxSize())
                    1 -> BisectionMethodUI(modifier = Modifier.fillMaxSize())
                    2 -> NewtonMethodUI(modifier = Modifier.fillMaxSize())
                }
            }
        }
    }
}


/*
@Composable
@Preview
fun App() {
    MaterialTheme {
        //var showContent by remember { mutableStateOf(false) }
        var selectedContent by remember { mutableStateOf(0) }
        Row (
            modifier = Modifier
                .background(MaterialTheme.colorScheme.primaryContainer)
                .safeContentPadding()
                .fillMaxSize(),
        ) {
            BaseSection(
                modifier = Modifier.weight(3f),
                onMethodSelected = {content->
                    selectedContent = content
                }
            )

            when (selectedContent){
                0 -> FixedPointIterationUI(modifier = Modifier.weight(5f))
                1 -> BisectionMethodUI(modifier = Modifier.weight(5f))
                2 -> NewtonMethodUI(modifier = Modifier.weight(5f))
            }

        }
    }
}*/
