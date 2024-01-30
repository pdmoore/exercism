class RunLengthEncoding {

    static encode(input) {
        def result = ""
        def prevCh = ""
        def count = 1
        for (char ch : input.toCharArray()) {
            if (prevCh == "") {
                prevCh = ch
                count = 1
            } else {
                if (prevCh.equals(ch)) {
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

        if (prevCh != "") {
            if (count > 1) {
                result += count
            }
            result += prevCh
        }

        return result
    }

    static decode(input) {
        def result = ""
        def count = ""
        for (char ch : input.toCharArray()) {
            if (ch >= '1' && ch <= '9') {
                count += ch
            } else {
                if (!count.isEmpty()) {
                    for (int i = 1; i <= count.toInteger(); i++) {
                        result += "$ch"
                    }

                    count = ""
                } else {
                    result += ch
                }
            }
        }
        return result
    }
}