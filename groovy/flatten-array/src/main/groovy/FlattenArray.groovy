class FlattenArray {
    static List flatten(List l) {
        def result = []
        l.each {
            result.add(it)
        }
        return result
    }
}
