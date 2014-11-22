public class PlusOne {
    public int[] plusOne(int[] digits) {
        if (digits == null) return null;

        int last = digits.length - 1; // the last digit index to plus one
        while (last >= 0 && digits[last] == 9) {
            digits[last--] = 0;
        }

        if (last < 0) { // e.g 999 => 1000
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            return result;
        } else {
            digits[last]++;
        }

        return digits;
    }
}