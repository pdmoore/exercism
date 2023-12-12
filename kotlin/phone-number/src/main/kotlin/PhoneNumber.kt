class PhoneNumber(var raw_number: String) {

    private val clean_number: String?
    private val clean_number2: String?
    init {
        clean_number = raw_number.filter(Char::isDigit)
        require(arrayOf(10, 11).contains(clean_number.length))
        if (clean_number.length == 11) require(clean_number.startsWith("1"))
        clean_number2 = clean_number.takeLast(10);
        require(validAreadCode(clean_number.takeLast(10)))
        require(validExchangeCode(clean_number.takeLast(10)))
    }

    private fun validAreadCode(takeLast: String) = (('2'..'9').contains(takeLast[0]))
    private fun validExchangeCode(takeLast: String) = (('2'..'9').contains(takeLast[3]))

    val number: String? = clean_number2
}
