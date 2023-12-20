class RunLengthEncoding {

    static encode(input) {
        def result = ""
        def prevCh = null
        def count = 0
        for (char ch : input.toCharArray()) {
            if (prevCh == null) {
                prevCh = ch
                count = 1
            } else {
                if (ch == prevCh) {
                    count++
                } else {
                    if (count > 1) {
                        result += count
                        count = 1
                    }
                    result += prevCh
                    prevCh = ch
                }
            }
        }

        if (prevCh != null) {
            if (count > 1) {
                result += count
            }
            result += prevCh
        }


        return result
    }

    static decode(input) {
        throw new UnsupportedOperationException('Method implementation is missing')
    }
}