fun reverse(input: String): String {
    if (input.isEmpty()) return input
    return input.last().toString()
        .plus(reverse(input.substring(0, input.length - 1)))
}
