class PhoneNumber(var raw_number: String) {

    private val clean_number: String?
    init {
        val justDigits = raw_number.filter(Char::isDigit)
        require(arrayOf(10, 11).contains(justDigits.length))
        if (justDigits.length == 11) require(justDigits.startsWith("1"))
        clean_number = justDigits.takeLast(10);
        require(validAreadCode(justDigits.takeLast(10)))
        require(validExchangeCode(justDigits.takeLast(10)))
    }

    private fun validAreadCode(takeLast: String) = (('2'..'9').contains(takeLast[0]))
    private fun validExchangeCode(takeLast: String) = (('2'..'9').contains(takeLast[3]))

    val number: String? = clean_number
}
