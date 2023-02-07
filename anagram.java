public boolean isAnagram(String s, String t) {
        int[] total = new int[27];
        int ascii_factor = 97;

        if(s.length() != t.length()) return false;

        for(int i = 0; i< s.length(); i++) {
            total[i- s.charAt(i) - 97] += 1;
            total[i - t.charAt(i) - 97] -= 1;
        }

        for(int val: total) {
            if(val != 0) return false;
        }

        return true;
        
    }

// GROUP ANAGRAM
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