import kotlin.math.sqrt

object Darts {

    // param can be Int or Double

    // Number accepts either but also a bunch more

    fun score(x: Int, y: Int): Int {

        val distance = sqrt((x * x).toDouble() + (y * y).toDouble())

        when (distance) {
            10.0 -> return 1
            else -> return 0
        }
    }

    fun score(x: Double, y: Double): Int {
        return -99
    }

    fun score(x: Double, y: Int): Int {
        return -99
    }
}