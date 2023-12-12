class PhoneNumber(var raw_number: String) {

    private val clean_number: String?
    init {
        clean_number = raw_number.replace("(", "")
            .replace(")", "")
            .replace("-", "")
            .replace(" ", "")
    }


    val number: String? = clean_number
}
