object Hamming {

    fun compute(l: String, r: String): Int {
        require (l.length == r.length) { "left and right strands must be of equal length." }

        return l.zip(r).count { it.first != it.second }
   }
}
