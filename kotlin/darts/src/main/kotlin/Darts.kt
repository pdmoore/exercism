import kotlin.math.hypot
import kotlin.math.sqrt

object Darts {
    val INNER_CIRCLE = 0.0..1.0
    val MIDDLE_CIRCLE = 1.0..5.0
    val OUTER_CIRCLE = 5.0..10.0

    fun score(x: Int, y: Int): Int = score(x.toDouble(), y.toDouble())
    fun score(x: Double, y: Int): Int = score(x, y.toDouble())

    fun score(x: Double, y: Double): Int {
        val distanceFromCenter = hypot(x, y)

        when {
            distanceFromCenter in INNER_CIRCLE  -> return 10
            distanceFromCenter in MIDDLE_CIRCLE -> return 5
            distanceFromCenter in OUTER_CIRCLE  -> return 1
            else -> return 0
        }
    }
}