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