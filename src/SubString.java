import java.util.HashSet;
import java.util.Set;

public class SubString {
    public static void main(String[] args) {
        String example = "pwwkew";
        // 7 12

        lengthOfLongestSubstring(example);
    }

    public static int lengthOfLongestSubstring(String s) {
        // https://leetcode.com/problems/longest-substring-without-repeating-characters/
        int len = s.length();
        HashSet<Character> characters = new HashSet<>();
        int soln = 0, left = 0, right = 0;
        System.out.println("length: " + len);
        int loops = 0;

        boolean condition = left < len && right < len; // 25 loops
        boolean condition2 = left < len && right < len && (left + soln) < len; // 8 loops can't use because it ends early

        // 25
        while(left < len && right < len){
            loops++;
            // if it's unique, keep going
            char rightChar = s.charAt(right);
            char leftChar = s.charAt(left);
            boolean isUnique = !characters.contains(rightChar);
            visualizeMap(characters, left, right);

            if(isUnique) {
                characters.add(s.charAt(right++));
                System.out.println(characters);
                int lengthOfCharacters = right - left;
                soln = Math.max(soln, lengthOfCharacters);
            } else {
                // otherwise remove
                characters.remove(s.charAt(left++));
            }
        }

        System.out.println("Soln: " + soln + " w/ " + loops + " loops");
        return soln;
    }

    public static void visualizeMap(HashSet<Character> map, int leftIndex, int rightIndex) {
        int len = map.toArray().length;
        if (len < 1) return;

        System.out.println("---");
        System.out.println("Left: " + leftIndex + " " + map + " Right: " + rightIndex);
        StringBuilder outStr = new StringBuilder();
        int i = 0;
        for (Character element:map) {
//            System.out.println("element: " + element);
            if(i == leftIndex) {
                outStr.append(i);
            } else if (i == rightIndex) {
                outStr.append(i);
            } else {
                outStr.append(element);
            }
            i++;
        }
        outStr.toString();
        System.out.println(outStr);
    }

    public static int lengthOfLongestSubstring2(String s) {
        int length = s.length();
        Set<Character> characters = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < length && j < length) {
            // if the character is new add
            if (!characters.contains(s.charAt(j))){
                characters.add(s.charAt(j++));
                // post increment executes after adding thus -1
                ans = Math.max(ans, j - i);
            }
            else {
                characters.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    public int lengthOfLongestSubstring3(String s) {
        int n = s.length();
        int maxLength = 0;
        Set<Character> charSet = new HashSet<>();
        int left = 0;

        for (int right = 0; right < n; right++) {
            if (!charSet.contains(s.charAt(right))) {
                charSet.add(s.charAt(right));
                maxLength = Math.max(maxLength, right - left + 1);
            } else {
                while (charSet.contains(s.charAt(right))) {
                    charSet.remove(s.charAt(left));
                    left++;
                }
                charSet.add(s.charAt(right));
            }
        }

        return maxLength;
    }
}
