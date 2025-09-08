package org.assignment.project.model

fun newtonMethod(
    f: (Double) -> Double,
    fPrime: (Double) -> Double,
    x0: Double,
    tol: Double,
    maxIter: Int
): List<IterationResult> {
    val results = mutableListOf<IterationResult>()
    var x = x0

    for (i in 1..maxIter) {
        val fx = f(x)
        val fpx = fPrime(x)
        if (fpx == 0.0) break  // avoid division by zero

        val xNext = x - fx / fpx
        val error = kotlin.math.abs(xNext - x)
        results.add(IterationResult(i, xNext, error))

        if (error < tol) break
        x = xNext
    }
    return results
}
