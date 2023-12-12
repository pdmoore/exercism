class Triangle<out T : Number>(val a: T, val b: T, val c: T) {
    private var _sideLengths: Set<T>
    init {
        if (a == 0 || b == 0 || c == 0) throw IllegalArgumentException()
        val sidesAsNumbers = listOf(a.toDouble(), b.toDouble(), c.toDouble())
        require(sidesAsNumbers[0] + sidesAsNumbers[1] > sidesAsNumbers[2])
        require(sidesAsNumbers[0] + sidesAsNumbers[2] > sidesAsNumbers[1])
        require(sidesAsNumbers[1] + sidesAsNumbers[2] > sidesAsNumbers[0])

        _sideLengths = setOf(a, b, c)
    }

    val isEquilateral: Boolean = _sideLengths.size == 1
    val isIsosceles: Boolean = _sideLengths.size <= 2
    val isScalene: Boolean = _sideLengths.size == 3
}
