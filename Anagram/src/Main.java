import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] strs = new String[]{"bat","nat","tan","ate","eat","tea"};
        groupAnagrams(strs);

        System.out.println("Hello world!");
    }

    public static boolean isAnagram(String s, String t) {
        int[] total = new int[27];

        if(s.length() != t.length()) return false;

        for(int i = 0; i< s.length(); i++) {
            total[i- s.charAt(i)] += 1;
            total[i - t.charAt(i)] -= 1;
        }

        for(int val: total) {
            if(val != 0) return false;
        }

        return true;

    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> anaGram = new ArrayList();
        Map<String, List<String>> tracker = new HashMap();

        for(String str: strs) {
            String sorted = sortedString(str);
            List<String> existingList = tracker.get(sorted);
            if(existingList == null) {
                List<String> newList = new ArrayList<>();
                newList.add(str);
                tracker.put(sorted, newList);
            } else {
                existingList.add(str);
            }
        }

        for(Map.Entry<String, List<String>> track : tracker.entrySet()) {
            anaGram.add(track.getValue());
        }

        return anaGram;
    }

    public static String sortedString(String str) {
        char[] charArr = str.toCharArray();
        Arrays.sort(charArr);
        return String.valueOf(charArr);
    }

    public int[] topKFrequent(int[] nums, int k) {
        if(nums.length == 0) {
            int[] empty = new int[0];
            return empty;
        }
        if(nums.length == 1) return nums;

        Map<Integer, Integer> tracker = new HashMap();

        for(int num: nums) {
            if(!tracker.containsKey(num)){
                tracker.put(num, 1);
            }else {
                int count = tracker.get(num);
                count++;
                tracker.put(num, count);
            }
        }

        int[] frequency = new int[k];
        for(int i = 0; i < k; i++) {
            int numOfOc= 0;
            int highNum = 0;
            for(Map.Entry<Integer, Integer> mapVal: tracker.entrySet()){
                int value = mapVal.getValue();
                if(value > numOfOc) {
                    highNum =  mapVal.getKey();
                }
            }
            tracker.remove(highNum);
            frequency[i] = highNum;
        }

        return frequency;
    }
}