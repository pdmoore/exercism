class PhoneNumber(var raw_number: String) {

    private var clean_number: String?
    init {
        val pattern = "[-.\\(\\)\\s+]".toRegex()
        clean_number = raw_number.replace(pattern, "")
        if (clean_number!!.length == 11 && clean_number!!.startsWith("1")) {
            clean_number = clean_number!!.substring(1)
        }
        require(clean_number!!.length == 10)
        require(clean_number!!.matches("[0-9]+".toRegex()))
    }


    val number: String? = clean_number
}
