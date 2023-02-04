import java.util.Arrays;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        int[] dup = {1,2,3,4,1};
        int[] dup2 = {1,2,3,4,5};
        dup['a'- 97] = 1;
        if(containsDuplicate(dup))  {
            System.out.println("DUPLICATE");
        } else {
            System.out.println("NO DUPLICATE");
        }
        if(containsDuplicate2(dup2))  {
            System.out.println("DUPLICATE");
        } else {
            System.out.println("NO DUPLICATE");
        }
    }

    public static boolean containsDuplicate(int[] nums) {
        if(nums.length <= 1) return false;
        Arrays.sort(nums);
        for(int i = 0; i<nums.length -1; i++) {
            if(nums[i] == nums[i+1]) return true;
        }
        return false;
    }

    public static boolean containsDuplicate2(int[] nums) {
        if(nums.length <= 1) return false;
        HashSet<Integer> numbers = new HashSet<Integer>();

        for(int i = 0; i<nums.length; i++) {
            if(numbers.contains(nums[i])) return true;
            numbers.add(nums[i]);
        }
        return false;
    }
}