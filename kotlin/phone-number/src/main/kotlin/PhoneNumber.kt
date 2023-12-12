class PhoneNumber(var raw_number: String) {

    private val clean_number: String?
    init {
        val pattern = "\\s+".toRegex()
        clean_number = raw_number.replace("(", "")
            .replace(")", "")
            .replace("-", "")
            .replace(".", "")
            .replace(pattern, "")
    }


    val number: String? = clean_number
}
