object EliudsEggs {
    fun eggCount(number: Int): Int = number
        .toString(2)
        .count { it == '1' }
}
