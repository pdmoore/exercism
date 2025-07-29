import kotlin.math.sqrt

object Darts {

    val INNER_CIRCLE = 0.0..1.0
    val MIDDLE_CIRCLE = 1.0..5.0
    val OUTER_CIRCLE = 5.0..10.0

    fun score(x: Int, y: Int): Int {
        return score(x.toDouble(), y.toDouble())
    }

    fun score(x: Double, y: Double): Int {
        val distance = sqrt((x * x) + (y * y))

        when {
            distance in INNER_CIRCLE -> return 10
            distance in MIDDLE_CIRCLE -> return 5
            distance in OUTER_CIRCLE -> return 1
            else -> return 0
        }
    }

    fun score(x: Double, y: Int): Int {
        return score(x, y.toDouble())
    }
}