class Triangle<out T : Number>(val a: T, val b: T, val c: T) {
    private var _sideLengths: Set<T>
    init {
        if (a == 0 || b == 0 || c == 0) throw IllegalArgumentException()
        _sideLengths = setOf(a, b, c)
    }
    // TODO: Implement proper constructor


    val isEquilateral: Boolean = _sideLengths.size == 1
    val isIsosceles: Boolean = true
    val isScalene: Boolean = true
}
