import kotlin.math.hypot
import kotlin.math.sqrt

object Darts {
    val INNER_CIRCLE = 0.0..1.0
    val MIDDLE_CIRCLE = 1.0..5.0
    val OUTER_CIRCLE = 5.0..10.0

    fun score(x: Number, y: Number): Int {
        val distanceFromCenter = hypot(x.toDouble(), y.toDouble())

        return when {
            distanceFromCenter in INNER_CIRCLE  -> 10
            distanceFromCenter in MIDDLE_CIRCLE ->  5
            distanceFromCenter in OUTER_CIRCLE  ->  1
            else -> 0
        }
    }
}