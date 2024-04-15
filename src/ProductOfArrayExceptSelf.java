public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {

        int product = 1;
        int zero = 0;
        for (int num : nums) {
            if (num == 0) {
                zero++;
                continue;
            }
            product *= num;
        }

        int[] result = new int[nums.length];
        if (zero == 1) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0)
                    result[i] = product;
                else
                    result[i] = 0;
            }
        } else if (zero > 1) {
            return new int[nums.length];
        } else {
            for (int i = 0; i < nums.length; i++) {
                result[i] = product / nums[i];
            }
        }

        return result;
    }

}
