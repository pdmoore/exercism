class AllYourBase {

    int inputBase;
    int value;

    AllYourBase(inputBase, digits) {
        this.inputBase = inputBase;
        def sum = 0;
        for (int i = 0; i < digits.size; i++) {
            sum += (inputBase**(digits.size - i - 1)) * digits[i];
        }

        this.value = sum;
    }

    def rebase(outputBase) {
        if (this.value == 0) {
            return [0];
        }

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