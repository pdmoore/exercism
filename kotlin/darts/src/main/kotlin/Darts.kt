import kotlin.math.sqrt

object Darts {

    // param can be Int or Double

    // Number accepts either but also a bunch more

    fun score(x: Int, y: Int): Int {

        return score(x.toDouble(), y.toDouble())
    }

    fun score(x: Double, y: Double): Int {
        val distance = sqrt((x * x) + (y * y))

        if (distance in 0.0..1.0) {
            return 10
        } else if (distance in 1.0..5.0) {
            return 5
        } else if (distance <= 10.0) {
            return 1
        }
        return 0

//        when (distance in) {
//            0.0..<1.0  -> return 10
//            1.0  -> return 10
//            5.0  -> return 5
//            10.0 -> return 1
//            else -> return 0
//        }
    }

    fun score(x: Double, y: Int): Int {
        return -99
    }
}