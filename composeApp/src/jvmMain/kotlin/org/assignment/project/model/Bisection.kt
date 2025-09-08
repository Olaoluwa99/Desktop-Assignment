package org.assignment.project.model

fun bisectionMethod(
    f: (Double) -> Double,
    a0: Double,
    b0: Double,
    tol: Double,
    maxIter: Int
): List<IterationResult> {
    val results = mutableListOf<IterationResult>()
    var a = a0
    var b = b0
    var c: Double

    for (i in 1..maxIter) {
        c = (a + b) / 2.0
        val error = kotlin.math.abs(b - a) / 2.0
        results.add(IterationResult(i, c, error))

        if (error < tol || f(c) == 0.0) break

        if (f(a) * f(c) < 0) {
            b = c
        } else {
            a = c
        }
    }
    return results
}
