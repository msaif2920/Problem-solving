  public static int[] productExceptSelf(int[] nums) {
        int size = nums.length;
        int[] result = new int[size];
        result[0] = 1;

        for(int i = 1; i<size; i++) {
            result[i] = nums[i - 1] * result[i-1];
        }

        int product = 1;

        for(int j = size - 1; j>=0; j--) {
            result[j] *= product;
            product *= nums[j];
        }
        return result;

    }