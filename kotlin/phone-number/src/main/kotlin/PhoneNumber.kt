class PhoneNumber(var raw_number: String) {

    private val clean_number: String?
    init {
        val pattern = "[-.\\(\\)\\s+]".toRegex()
        clean_number = raw_number.replace(pattern, "")
        require(clean_number.length == 10)
    }


    val number: String? = clean_number
}
