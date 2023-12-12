class PhoneNumber(var raw_number: String) {

    private val clean_number: String?
    init {
        clean_number = raw_number.filter(Char::isDigit)
        require(arrayOf(10, 11).contains(clean_number.length))
        if (clean_number.length == 11) require(clean_number.startsWith("1"))
        require(validAreadCode())
        require(validExchangeCode())
    }

    private fun validAreadCode() = (('2'..'9').contains(clean_number?.get(0) ?: true))
    private fun validExchangeCode() = (('2'..'9').contains(clean_number?.get(3) ?: true))

    val number: String? = clean_number
}
