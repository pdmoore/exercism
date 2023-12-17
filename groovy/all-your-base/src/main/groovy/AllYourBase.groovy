class AllYourBase {

    int inputBase;
    def digits;
    int value;

    AllYourBase(inputBase, digits) {
        this.inputBase = inputBase;
        this.digits = digits;
        if (inputBase == 10) {
            this.value = digits[0];
        }
        if (inputBase == 2) {
            this.value = 1;
        }
    }

    def rebase(outputBase) {
        if (outputBase == 10) {
            return [value];
        }

        if (outputBase == 2) {
            def result = [];
            int num = this.value;
            while (num > 0) {
                int remainder = num % 2;
                result.add(remainder);
                num = num / 2;
            }
            return result;
        }


    }
}