import java.lang.IllegalArgumentException

object Hamming {

    fun compute(l: String, r: String): Int {
        if (l.length != r.length) {
            throw IllegalArgumentException("left and right strands must be of equal length.")
        }

        var count = 0

        for (index in l.indices) {
            when (l[index] == r[index]) {
                false -> count++
            }
        }

       return count;
   }
}
