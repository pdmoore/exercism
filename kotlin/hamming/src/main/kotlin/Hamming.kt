object Hamming {

    fun compute(l: String, r: String): Int {
        var count = 0

        for (index in l.indices) {
            when (l[index] == r[index]) {
                false -> count++
            }
        }


       return count;
   }
}
