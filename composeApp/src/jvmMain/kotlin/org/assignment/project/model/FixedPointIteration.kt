package org.assignment.project.model

data class IterationResult(val iteration: Int, val x: Double, val error: Double)

fun fixedPointIteration(
    g: (Double) -> Double,
    x0: Double,
    tol: Double,
    maxIter: Int
): List<IterationResult> {
    val results = mutableListOf<IterationResult>()
    var x = x0
    for (i in 1..maxIter) {
        val xNext = g(x)
        val error = kotlin.math.abs(xNext - x)
        results.add(IterationResult(i, xNext, error))
        if (error < tol) break
        x = xNext
    }
    return results
}
