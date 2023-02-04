  public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> values = new HashMap<Integer, Integer>();
        for(int i = 0; i<nums.length; i++) {
                int val = target - nums[i];
                if(values.containsKey(val)) {
                    return new int[] { values.get(val), i};
                }
                values.put(nums[i], i);
        }

        return new int[]{0, 0};
    }