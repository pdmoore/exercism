class AllYourBase {

    int inputBase;
    def digits;
    int value;

    AllYourBase(inputBase, digits) {
        this.inputBase = inputBase;
        this.digits = digits;
        if (inputBase == 10) {
            def size = digits.size;
            def sum = 0;
            for (int i = 0; i < size; i++) {
                sum += (10**(size - i - 1)) * digits[i];
            }

            this.value = sum;
        }
        if (inputBase == 2) {
            def size = digits.size;
            def sum = 0;
            for (int i = 0; i < size; i++) {
                sum += (2**(size - i - 1)) * digits[i];
            }

            this.value = sum;
        }
    }

    def rebase(outputBase) {
        def result = [];
        int num = this.value;
        while (num > 0) {
            int remainder = num % outputBase;
            result.add(remainder);
            num = num / outputBase;
        }

        return result.reverse();
    }
}