class FlattenArray {
    static List flatten(List l) {
        def result = []
        l.each {
            if (l instanceof List) {
                it.each {
                    result.add(it)

                }
            } else {

                result.add(it)
            }
        }
        return result
    }
}
