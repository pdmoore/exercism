class PhoneNumber(var raw_number: String) {

    private var clean_number: String?
    init {
        val pattern = "[-.\\(\\)\\s+]".toRegex()
        clean_number = raw_number.replace(pattern, "")
        if (clean_number!!.length == 11 && clean_number!!.startsWith("1")) {
            clean_number = clean_number!!.substring(1)
        }
        require(clean_number!!.length == 10)
        require(validAreadCode())
        require(validExchangeCode())
        require(clean_number!!.matches("[0-9]+".toRegex()))
    }


    private fun validAreadCode() = (!clean_number!!.startsWith("0") && !clean_number!!.startsWith("1"))
    private fun validExchangeCode() = (clean_number!!.get(3) != '0' &&  clean_number!!.get(3) != '1')

    val number: String? = clean_number
}
